package loja.model.cliente;
import java.math.BigDecimal;

import loja.model.produto.Produto;

public class Cliente {
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
}
