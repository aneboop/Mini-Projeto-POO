package loja.model.cliente;

public class PessoaFisica extends Cliente{
    private String cpf;

    public PessoaFisica(String identificadorUnico, String nome, String endereco, String telefone, String cpf) {
        super(identificadorUnico, nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
