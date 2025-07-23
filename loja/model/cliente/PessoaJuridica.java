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

    public String[] obterMensagensErro() {
        String[] errosBase = super.obterMensagensErro();
        int count = errosBase.length;
        
        if (cnpj == null || !cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            count++;
        }
        
        String[] erros = new String[count];
        
        System.arraycopy(errosBase, 0, erros, 0, errosBase.length);
        
        if (cnpj == null || !cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            erros[errosBase.length] = "CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX";
        }
        
        return erros;
    }

    public String exibirDetalhes() {
        return "CNPJ: " + this.getCnpj();
    }
}