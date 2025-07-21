package loja;
import loja.model.UI.ConsoleMenu;
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
        opcao = InputUtils.getInput("Escolha uma opcao ");
        if(opcao == 1){
            ConsoleMenu.cadastrarProduto(produtos, numProdutos);
        }
        else if(opcao == 2){
           ConsoleMenu.alterarProduto(produtos, numProdutos);
        }
        else if(opcao == 3){
           ConsoleMenu.cadastrarCliente(clientes, numClientes);
        }
        else if(opcao == 4){
           ConsoleMenu.alterarCliente(clientes, numClientes);
        }
        else if(opcao == 5){
           ConsoleMenu.criarNota(notas, numNotas, clientes, numClientes, produtos, numProdutos);
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
        else {
            System.out.println("Opcao inválida.");
        }
        }while(opcao!=0);
        
    }
}
    
    
