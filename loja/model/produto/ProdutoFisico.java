package loja.model.produto;
import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
    private int paginas; 
    private BigDecimal valorfrete;

    public ProdutoFisico(String nome, String codigo, int estoque, BigDecimal precoBase, BigDecimal valorfrete, int paginas){
        super(nome, codigo, estoque, precoBase);
        this.valorfrete = valorfrete;
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }

    public BigDecimal getvalorfrete(){
        return valorfrete;
    }

    public BigDecimal calcularPrecoVenda() {
        return this.getPrecoBase().add(this.valorfrete);
    }
    public String exibirDetalhes() {
        return "Tipo: Físico \nPáginas: " + this.getPaginas() + " \nValor Frete: " + this.getvalorfrete();
    }
    
}