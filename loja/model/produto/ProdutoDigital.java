
package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
    private int mb;

    public ProdutoDigital(String nome, String codigo, int estoque, BigDecimal precoBase, int mb){
        super(nome, codigo, estoque, precoBase);
        this.mb = mb;
    }

    public int getmb() {
        return mb;
    }

    public BigDecimal calcularPrecoVenda(){
        return getPrecoBase();
    }

    public String exibirDetalhes() {
        return "Tipo: Digital \nMB: " + this.getmb();
    }
    
}
