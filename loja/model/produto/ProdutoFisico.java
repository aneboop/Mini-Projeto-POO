package loja.model.produto;
import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
    private int paginas; 

    public ProdutoFisico(String nome, String codigo, int estoque, BigDecimal precoBase, BigDecimal valorfrete, int paginas){
        super(nome, codigo, estoque, precoBase, valorfrete);
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }

    public BigDecimal calcularPrecoVenda(){
        return getPrecoBase().add(valorfrete);
    }
    
}
