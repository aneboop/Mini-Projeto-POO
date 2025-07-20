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
    public static Produto cadastrarProduto(){
        System.out.println("\n------ CADASTRO ------");
        String nome = InputUtils.getStringInput("Nome do produto: ");
        String codigo = InputUtils.getStringInput("Codigo: ");
        int estoque = InputUtils.getInput("Estoque inicial: ");
        BigDecimal precoBase = InputUtils.getBigDecimalInput("Preço base: ");
       
      
        System.out.println("Tipo de Produto:");
        System.out.println("1. Produto Físico");
        System.out.println("2. Produto Digital");
        int tipoProduto = InputUtils.getInput("Escolha o tipo de produto: ");

        if (tipoProduto == 1) {
            BigDecimal valorFrete = InputUtils.getBigDecimalInput("Valor do frete: ");
            int paginas = InputUtils.getInput("Número de páginas (para produtos físicos): ");
            return new ProdutoFisico(nome, codigo, estoque, precoBase, valorFrete, paginas);
        } else if (tipoProduto == 2) {
            int mb = InputUtils.getInput("Tamanho em MB: ");
            return new ProdutoDigital(nome, codigo, estoque, precoBase, mb);
        } else {
            System.out.println("Tipo de produto inválido.");
            return null;
        }

    }
    //OPCAO 2
    public static void alterarProduto(Produto produtoalterado){
         System.out.println("\n------ ALTERACAO DE PRODUTO ------");
         System.out.println("Escolha qual atributo deseja alterar"); 
         System.out.println("1. Preco Base"); 
         System.out.println("2. Estoque"); 
         int tipoAlteracao = InputUtils.getInput("Escolha uma opcao: ");

         if(tipoAlteracao == 1){
            BigDecimal precoBase = InputUtils.getBigDecimalInput("Novo preço base: ");
            produtoalterado.setPrecoBase(precoBase);
         }else if(tipoAlteracao == 2){
            int estoque = InputUtils.getInput("Novo estoque: ");
            produtoalterado.setEstoque(estoque);
         }else {
            System.out.println("Opcao inválida.");
            
        }
    }
    //OPCAO 3
    public static Cliente cadastrarCliente(){
        System.out.println("\n------ CADASTRO DE CLIENTE ------");
        String nome = InputUtils.getStringInput("Nome: ");
        String endereco = InputUtils.getStringInput("Endereço: ");
        String telefone = InputUtils.getStringInput("Telefone: ");
        String identificadorBase = InputUtils.getStringInput("Codigo: ");
        String digitoIdentificador;
        String indentifucadorFinal;

        System.out.println("Tipo de Cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Juridica");
        int tipoCliente = InputUtils.getInput("Escolha uma opcao: ");

        if(tipoCliente == 1){
            digitoIdentificador = "01-";
            indentifucadorFinal = digitoIdentificador+identificadorBase;
            String CPF = InputUtils.getStringInput("CPF: ");
            return new PessoaFisica(indentifucadorFinal, nome, endereco, telefone, CPF);
        } else if (tipoCliente == 2) {
            digitoIdentificador = "02-";
            indentifucadorFinal = digitoIdentificador+identificadorBase;
            String CNPJ = InputUtils.getStringInput("CNPJ: ");
            return new PessoaJuridica(indentifucadorFinal, nome, endereco, telefone, CNPJ);
        }else {
            System.out.println("Tipo de produto inválido.");
            return null;
        }


    }
    //OPCAO 4
    public static void alterarCliente(Cliente clientealterado){
         System.out.println("\n------ ALTERACAO DE CLIENTE ------");
         System.out.println("Escolha qual atributo deseja alrerar"); 
         System.out.println("1. Telefone"); 
         System.out.println("2. Endereco"); 
         int tipoAlteracao = InputUtils.getInput("Escolha uma opcao: ");

         if(tipoAlteracao == 1){
            String telefone = InputUtils.getStringInput("Novo telefone base: ");
            clientealterado.setTelefone(telefone);
         }else if(tipoAlteracao == 2){
            String endereco = InputUtils.getStringInput("Novo endereco base: ");
            clientealterado.setTelefone(endereco);
         }else {
            System.out.println("Opcao inválida.");
            
        }
    }
    
    //OPCAO 5 -> na classe Nota ou diretamente na classe Main, caso seja na classe Main, fica fora do "public static void"


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
        System.out.println("\n--- Clientes cadastrados ---");
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


            }
    }
    
    // BuscarClientes() e BuscarProdutos() para criar a nota no main
}
