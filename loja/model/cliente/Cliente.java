package loja.model.cliente;
import loja.model.UI.IValidavel;

public abstract class Cliente implements IValidavel {
    private String identificador;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(String identificador, String nome, String endereco, String telefone) {
        this.identificador = identificador;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }


    public String getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String exibirDetalhes(){
        return "";
    }

    public static int pesquisarCliente(Cliente[] clientes, int numClientes, String indentificador){
    for(int i = 0; i < numClientes; i++){
        if (clientes[i].identificador.equals(indentificador)){
            return i;
        }
    }
    return -1;
    }
    
    public boolean validar() {
     return obterMensagensErro().length == 0;
    }
  
    public String[] obterMensagensErro() {
     int count = 0;
     if (identificador == null || !identificador.matches("\\d{2}-\\d{3}")) count++;
     if (nome == null || nome.trim().isEmpty()) count++;
     if (endereco == null || endereco.trim().isEmpty()) count++;
     if (telefone == null || !telefone.matches("\\d{6,7}-\\d{4}")) count++;
     String[] erros = new String[count];
     int index = 0;
     if (identificador == null || !identificador.matches("\\d{2}-\\d{3}")) {
     erros[index++] = "Identificador deve estar no formato NN-NNN (2 dígitos, hífen, 3 dígitos)";
     }
     if (nome == null || nome.trim().isEmpty()) {
      erros[index++] = "Nome do cliente não pode ser vazio";
     }
     if (endereco == null || endereco.trim().isEmpty()) {
      erros[index++] = "Endereço não pode ser vazio";
     }
     if (telefone == null || !telefone.matches("\\d{6,7}-\\d{4}")) {
      erros[index++] = "Telefone deve estar no formato XXXXXX-XXXX ou XXXXXXX-XXXX";
     }
     return erros;
    }
}
