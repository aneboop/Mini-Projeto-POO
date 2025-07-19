package loja.model.UI;
import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInput(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            }   catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
            }
        }
    

     public static BigDecimal getBigDecimalInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}


    

