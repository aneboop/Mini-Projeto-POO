package loja.model.produto;
import java.math.BigDecimal;

public class Produto {
    // atributos
    private String nome;
    private String codigo;
    private int estoque;
    private BigDecimal precoBase;
  

    // construtor
    public Produto(String nome, String codigo, int estoque, BigDecimal precoBase){
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
        this.precoBase = precoBase;
    }

    //getters
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public int getEstoque() {
        return estoque;
    }

    

    //setters
    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public BigDecimal calcularPrecoVenda() {
        return getPrecoBase();
    }

    public String exibirDetalhes(){
        return "";
    }

    
}