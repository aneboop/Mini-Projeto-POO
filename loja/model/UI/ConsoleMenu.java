<<<<<<< HEAD
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
    // TODOS OS METODOS DE ALTERAÇÃO E EXIBIÇÃO DE CLIENTES E PRODUTOS DEVEM VIR NESSA CLASSE
    
}
=======
package loja.model.UI;
import java.math.BigDecimal;

public class ConsoleMenu {
    
}
>>>>>>> dbfb1aaf8c651476815f8a66fb9bc9c1c72cd2be
