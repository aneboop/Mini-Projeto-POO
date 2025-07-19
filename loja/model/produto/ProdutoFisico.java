package loja.model.produto;
import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
    private int paginas; // Exemplo de atributo específico para produto físico

    public ProdutoFisico(String nome, String codigo, int estoque, BigDecimal precoBase, int paginas){
        super(nome, codigo, estoque, precoBase);
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }

    public BigDecimal calcularPrecoVenda(BigDecimal valorfrete){
        BigDecimal precoBase = getPrecoBase();
        return  precoBase.add(valorfrete);
    }
    
}
