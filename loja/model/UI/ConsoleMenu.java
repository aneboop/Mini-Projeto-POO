package loja.model.UI;
import java.math.BigDecimal;
import loja.model.cliente.Cliente;
import loja.model.cliente.PessoaFisica;
import loja.model.cliente.PessoaJuridica;
import loja.model.nota.Nota;
import loja.model.produto.Produto;
import loja.model.produto.ProdutoDigital;
import loja.model.produto.ProdutoFisico;

public class ConsoleMenu {

    public static void exibirMenuPrincipal() {
        System.out.println("\n------ Menu Principal ------");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Cadastrar Cliente");
        System.out.println("4. Alterar Cliente");
        System.out.println("5. Criar Nota de Compra");
        System.out.println("6. Listar Notas Emitidas");
        System.out.println("7. Listar Produtos");
        System.out.println("8. Listar Clientes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    //OPCAO 1
    public static Produto cadastrarProduto(Produto[]produtos, int numProdutos){
        // Cadastro dinamio
        if(numProdutos == produtos.length){
            Produto[] aux = new Produto[numProdutos+10];
            for (int i = 0; i < produtos.length ; i++)
              aux[i]= produtos[i];
              produtos = aux;
        }

        System.out.println("\n------ CADASTRO ------");
        String nome = InputUtils.getStringInput("Nome do produto: ");
        int estoque = InputUtils.getInput("Estoque inicial: ");
        BigDecimal precoBase = InputUtils.getBigDecimalInput("Preço base: ");
        String codigo;
        
        //Garatindo codigo formatado e unico 
        int flag = 0;
        String entradaCodigo;
        do{
            flag= 0;
         entradaCodigo = InputUtils.getStringInput("Codigo: ");
         if (entradaCodigo==null || entradaCodigo.length() != 5){
          System.out.println("O codigo deve ter exatamente 5 caracteres");
         }else flag++;

         if(Produto.pesquisarProduto(produtos,numProdutos, entradaCodigo) >= 0){
          System.out.println("Codigo ja existente, cadastre um codigo diferente");
         }else flag++;
        }while(flag != 2);
        codigo = entradaCodigo;

        int tipoProduto;
        int paginas = 0;
        BigDecimal valorFrete = BigDecimal.ZERO;
        int mb = 0;
        do{
        System.out.println("Tipo de Produto:");
        System.out.println("1. Produto Físico");
        System.out.println("2. Produto Digital");
        tipoProduto = InputUtils.getInput("Escolha o tipo de produto: ");

        if (tipoProduto == 1) {
            valorFrete = InputUtils.getBigDecimalInput("Valor do frete: ");
            paginas = InputUtils.getInput("Número de páginas (para produtos físicos): ");
        } else if (tipoProduto == 2) {
            mb = InputUtils.getInput("Tamanho em MB: ");
        } else {
            System.out.println("Tipo de produto inválido.");
        }
        }while(tipoProduto!=1 && tipoProduto!=2);
        
        Produto novoProduto = tipoProduto == 1 ?
        new ProdutoFisico(nome, codigo, estoque, precoBase, valorFrete, paginas) :
        new ProdutoDigital(nome, codigo, estoque, precoBase, mb);
        if (!novoProduto.validar()) {
        System.out.println("Erros de validação:");
        for (String erro : novoProduto.obterMensagensErro()) {
        System.out.println("- " + erro);
        }
        return null;
        }

        produtos[numProdutos] = novoProduto;
        return novoProduto;
    
    }
    //OPCAO 2
    public static void alterarProduto(Produto[]produtos, int numProdutos){
         String codigoProduto;
         int index;

         System.out.println("\n------ ALTERACAO DE PRODUTO ------");
         System.out.println("Escolha qual produto deseja alterar"); 

         //Achar indice do produto na lista
         do{
          codigoProduto = InputUtils.getStringInput("Codigo: ");
          index = Produto.pesquisarProduto(produtos, numProdutos,codigoProduto);
          if(index == -1)
           System.out.println("Codigo invalido"); 
         }while(index == -1);

         System.out.println("Escolha qual atributo deseja alterar"); 
         System.out.println("1. Preco Base"); 
         System.out.println("2. Estoque"); 
         int tipoAlteracao = InputUtils.getInput("Escolha uma opcao: ");

         if(tipoAlteracao == 1){
            BigDecimal precoBase = InputUtils.getBigDecimalInput("Novo preço base: ");
            produtos[index].setPrecoBase(precoBase);
         }else if(tipoAlteracao == 2){
            int estoque = InputUtils.getInput("Novo estoque: ");
            produtos[index].setEstoque(estoque);
         }else {
            System.out.println("Opcao inválida.");
            
        }
    }
    //OPCAO 3
    public static Cliente cadastrarCliente(Cliente[] clientes, int numClientes){

        // Cadastro dinamio
        if(numClientes == clientes.length){
            Cliente[] aux = new Cliente[numClientes+10];
            for (int i = 0; i < clientes.length ; i++)
              aux[i]= clientes[i];
            clientes = aux;
        }

        System.out.println("\n------ CADASTRO DE CLIENTE ------");
        String nome = InputUtils.getStringInput("Nome: ");
        String endereco = InputUtils.getStringInput("Endereço: ");
        String telefone = InputUtils.getStringInput("Telefone: ");
        String entradaIdentificador;
        String digitoIdentificador;
        String identificadorFinal="";

        //selecionando o codigo
        int flag = 0;
        do{
            flag=0;
         entradaIdentificador = InputUtils.getStringInput("Codigo: ");
         if (entradaIdentificador==null || entradaIdentificador.length() != 3){
          System.out.println("O codigo deve ter exatamente 3 caracteres");
         }else flag++;

         if(Cliente.pesquisarCliente(clientes, numClientes, entradaIdentificador) >= 0){
          System.out.println("Codigo ja existente, cadastre um codigo diferente");
         }else flag++;
        }while(flag != 2);
        String identificadorBase = entradaIdentificador;

        //selecionando tipo
        String documento="";
        int tipoCliente;
        do{
        System.out.println("Tipo de Cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Juridica");
        tipoCliente = InputUtils.getInput("Escolha uma opcao: ");

        if(tipoCliente == 1){
            digitoIdentificador = "01-";
            identificadorFinal = digitoIdentificador+identificadorBase;
            System.out.println("ID Final: " + identificadorFinal);
            documento = InputUtils.getStringInput("CPF: ");

        } else if (tipoCliente == 2) {
            digitoIdentificador = "02-";
            identificadorFinal = digitoIdentificador+identificadorBase;
            documento = InputUtils.getStringInput("CNPJ: ");
           
        }else {
            System.out.println("Tipo de produto inválido.");
        }
        }while(tipoCliente!=1 &&  tipoCliente!=2);
        
        Cliente novoCliente = tipoCliente == 1 ?
        new PessoaFisica(identificadorFinal,nome, endereco, telefone, documento):
        new PessoaJuridica(identificadorFinal, nome, endereco, telefone, documento);
        if (!novoCliente.validar()) {
        System.out.println("Erros de validação:");
        for (String erro : novoCliente.obterMensagensErro()) {
        System.out.println("- " + erro);
        }
        return null;
        }

        clientes[numClientes] = novoCliente;
        return novoCliente;
    }
    //OPCAO 4
    public static void alterarCliente(Cliente[] clientes, int numClientes){
         String identificadorCliente;
         System.out.println("\n------ ALTERACAO DE CLIENTE ------");
         System.out.println("Escolha qual cliente deseja alterar"); 

         //Encontrar indice
         int index;
         do{
          identificadorCliente = InputUtils.getStringInput("Codigo: ");
          index = Cliente.pesquisarCliente(clientes, numClientes, identificadorCliente);
          if(index == -1)
           System.out.println("Codigo invalido"); 
         }while(index == -1);

         System.out.println("Escolha qual atributo deseja alterar"); 
         System.out.println("1. Telefone"); 
         System.out.println("2. Endereco"); 
         int tipoAlteracao = InputUtils.getInput("Escolha uma opcao: ");

         if(tipoAlteracao == 1){
            String telefone = InputUtils.getStringInput("Novo telefone base: ");
            clientes[index].setTelefone(telefone);
         }else if(tipoAlteracao == 2){
            String endereco = InputUtils.getStringInput("Novo endereco base: ");
            clientes[index].setEndereco(endereco);
         }else {
            System.out.println("Opcao inválida.");
            
        }
    }
    
    //OPCAO 5
    public static Nota criarNota(Nota[] notas,int numNotas, Cliente[] clientes, int numClientes,Produto[]produtos, int numProdutos ){

        // Cadastro dinamio
        if(numNotas == notas.length){
            Nota[] aux = new Nota[numNotas+10];
            for (int i = 0; i < notas.length ; i++)
              aux[i]= notas[i];
            notas = aux;
        }

        System.out.println("\n------ CRIACAO DE NOTA ------");
        System.out.println("Escolha o cliente"); 

         //Encontrar indice do cliente
         String identificadorCliente;
         int index_cliente;
         do{
          identificadorCliente = InputUtils.getStringInput("Codigo: ");
          index_cliente = Cliente.pesquisarCliente(clientes, numClientes, identificadorCliente);
          if(index_cliente == -1)
           System.out.println("Codigo invalido\n"); 
         }while(index_cliente == -1);

         //Criando a nota  
         String ID =  String.valueOf(numNotas);
         Nota novNota = new Nota(ID, clientes[index_cliente]);
         notas[numNotas] = novNota;

         //Adicionar os produtos
         String codigoProduto;
         int index_produto;
         int quantidadeProduto;
         int opcao;
         do{
         System.out.println("1 Para adicionar um produto "); 
         System.out.println("2 Para concluir a compra "); 
         opcao = InputUtils.getInput("Escolha uma opcao ");

         if(opcao == 1){
         //Achar indice do produto na lista
         do{
          codigoProduto = InputUtils.getStringInput("Codigo: ");
          index_produto = Produto.pesquisarProduto(produtos, numProdutos,codigoProduto);
          if(index_produto == -1)
           System.out.println("Codigo invalido\n"); 
         }while(index_produto == -1);
         quantidadeProduto = InputUtils.getInput("Quantidade do produto: ");
        if(novNota.adicionarItem(produtos[index_produto], quantidadeProduto)!=null)
            System.out.println("Produto adicionado com sucesso"); 
         }
         if(opcao!=1 && opcao !=2){
            System.out.println("Opcao invalida, selecione 1 ou 2\n"); 
         }
        }while(opcao != 2);
        novNota.exibirResumo();
        notas[numNotas]=novNota;
        return novNota;

    }

    //OPCAO 6
    public static void listarNotas(Nota[] notas, int numNotas){
        System.out.println("\n--- Notas Emitidas ---");
            if(numNotas == 0){
                System.out.println("Nenhuma nota emitida!");
                return;
            }
            for(int i = 0; i < numNotas; i++){
                notas[i].exibirResumo();
            }
    }

    //OPCAO 7
    public static void listarProdutos(Produto[]produtos, int numProdutos){
        System.out.println("\n--- Produtos cadastrados ---");
        if(numProdutos == 0){
                System.out.println("Nenhuma produto cadastrado!");
                return;
            }
            for(int i = 0; i < numProdutos; i++){
                Produto produto = produtos[i];
                System.out.println("Codigo: " + produto.getCodigo());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço Base: " + produto.getPrecoBase());
                System.out.println("Estoque: " + produto.getEstoque());
                    String detalhesProdutos = produto.exibirDetalhes();
                    System.out.print(detalhesProdutos);
                System.out.println("\n-----------------------------");    
                   


            }
        }

    //OPCAO 8
    public static void listarClientes(Cliente[]clientes, int numClientes){
        System.out.println("\n--- Clientes cadastrados ---");
        if(numClientes == 0){
                System.out.println("Nenhum cliente cadastrado!");
                return;
            }
            for(int i = 0; i < numClientes; i++){
                Cliente cliente = clientes[i];
                System.out.println("ID: " + cliente.getIdentificador());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Telefone: " + cliente.getTelefone());
                    String detalhesClientes = cliente.exibirDetalhes();
                    System.out.print(detalhesClientes);
                System.out.println("\n-----------------------------");      


            }
    }
    
    // BuscarClientes() e BuscarProdutos() para criar a nota no main
}
