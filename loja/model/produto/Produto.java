package loja.model.produto;
import java.math.BigDecimal;
import loja.model.UI.IValidavel;
public abstract class Produto implements IValidavel {
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

   public static int pesquisarProduto(Produto[] produtos, int numProdutos, String codigo){
    for(int i = 0; i < numProdutos; i++){
        if (produtos[i].codigo.equals(codigo)){
            return i;
        }
    }
    return -1;
    }

    
      @Override
    public boolean validar() {
       return obterMensagensErro().length == 0;
    }
    @Override
    public String[] obterMensagensErro() {
       int count = 0;
       // Primeiro contamos quantos erros teremos
     if (nome == null || nome.trim().isEmpty()) count++;
     if (codigo == null || codigo.length() != 5) count++;
     if (estoque < 0) count++;
     if (precoBase == null || precoBase.compareTo(BigDecimal.ZERO) <= 0) count++;
     // Agora criamos o array com tamanho exato
     String[] erros = new String[count];
     int index = 0;
     if (nome == null || nome.trim().isEmpty()) {
      erros[index++] = "Nome do produto não pode ser vazio";
     }
     if (codigo == null || codigo.length() != 5) {
      erros[index++] = "Código do produto deve ter exatamente 5 caracteres";
     }
     if (estoque < 0) {
      erros[index++] = "Estoque não pode ser negativo";
     }
     if (precoBase == null || precoBase.compareTo(BigDecimal.ZERO) <= 0) {
     erros[index++] = "Preço base deve ser maior que zero";
     }
     return erros;
    }
}



    
