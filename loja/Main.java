package loja;
import loja.model.UI.ConsoleMenu;
import loja.model.UI.InputUtils;
import loja.model.cliente.Cliente;
import loja.model.nota.Nota;
import loja.model.produto.Produto;
import loja.model.UI.InputUtils;
import loja.model.cliente.Cliente;
import loja.model.nota.Nota;
import loja.model.produto.Produto;

public class Main {
    public static void main(String[] args){

        //Criando listas
        Cliente[] clientes = new Cliente[20];
        int numClientes=0;
        Produto[] produtos =  new Produto[20];
        int numProdutos=0;
        Nota[] notas = new Nota[20];
        int numNotas=0;

        //loop principal
        int opcao;
        do{
        ConsoleMenu.exibirMenuPrincipal();
        opcao = InputUtils.getInput("");
        if(opcao == 1){
            if(ConsoleMenu.cadastrarProduto(produtos, numProdutos) != null){
            numProdutos++;
            System.out.println("Produto cadastrado com sucesso");
            }else System.out.println("Nao foi possivel realizar o cadastro");
         }
        else if(opcao == 2){
           ConsoleMenu.alterarProduto(produtos, numProdutos);
        }
        else if(opcao == 3){
           ConsoleMenu.cadastrarCliente(clientes, numClientes);
           numClientes++;
           System.out.println("Cliente cadastrasdo com sucesso");
        }
        else if(opcao == 4){
           ConsoleMenu.alterarCliente(clientes, numClientes);
        }
        else if(opcao == 5){
           if(ConsoleMenu.criarNota(notas, numNotas, clientes, numClientes, produtos, numProdutos) != null){
            numNotas++;
            System.out.println("Nota cadastrado com sucesso");
           }
        }
        else if(opcao == 6){
           ConsoleMenu.listarNotas(notas, numNotas);
        }
        else if(opcao == 7){
           ConsoleMenu.listarProdutos(produtos, numProdutos);
        }
        else if(opcao == 8){
           ConsoleMenu.listarClientes(clientes, numClientes);
        }
        else if(opcao>8 || opcao<0) {
            System.out.println("Opcao inválida.");
        }
        }while(opcao!=0);
        
    }
}
    
    
