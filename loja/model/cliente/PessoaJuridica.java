package loja.model.cliente;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String identificadorUnico, String nome, String endereco, String telefone, String cnpj) {
        super(identificadorUnico, nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}

    

