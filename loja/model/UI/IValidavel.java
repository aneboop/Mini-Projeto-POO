package loja.model.UI;
public interface IValidavel {

boolean validar();

//Obtem mensagens de erro de validação
String[] obterMensagensErro();
}