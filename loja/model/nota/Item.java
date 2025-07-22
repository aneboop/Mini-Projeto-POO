package loja.model.nota;
import loja.model.produto.Produto;
import java.math.BigDecimal;


public class Item {
    private Produto produto; 
    private int quantidade; 
    private BigDecimal subtotalItem; 

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotalItem = produto.calcularPrecoVenda().multiply(new BigDecimal(quantidade));
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotalItem(){
        BigDecimal valorfrete = produto.calcularPrecoVenda().subtract(produto.getPrecoBase());
        return this.subtotalItem.add(valorfrete);
    }
}
