package loja.model.cliente;

public class PessoaFisica extends Cliente{
    private String cpf;

    public PessoaFisica(String identificadorUnico, String nome, String endereco, String
      telefone, String cpf) {
      super(identificadorUnico, nome, endereco, telefone);
      this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String exibirDetalhes(){
     return "CPF: " + this.getCpf();
    }

    public String[] obterMensagensErro() {
     // Primeiro obtemos os erros da classe base
      String[] errosBase = super.obterMensagensErro();
      int count = errosBase.length;
     // Verificamos se temos erros adicionais
     if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
      count++;
     }
     // Criamos o array final
      String[] erros = new String[count];
     // Copiamos os erros da base
      System.arraycopy(errosBase, 0, erros, 0, errosBase.length);
     // Adicionamos nossos erros específicos
     if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
       erros[errosBase.length] = "CPF deve estar no formato XXX.XXX.XXX-XX";
     }
     return erros;
    }


}