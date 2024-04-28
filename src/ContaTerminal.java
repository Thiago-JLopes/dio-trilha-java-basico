import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Thiago José Lopes
 * @since 28/04/2024
 * 
 */

public class ContaTerminal {

    // Metodo para validar nome
    public static boolean validaNome(String nomeLido) {
        String auxiliar = nomeLido.toUpperCase(); // converte todos os caracters para maiusculos
        for (int i = 0; i < nomeLido.length(); i++) { // intera sobre cada carcter
            int caracterdoNomeLido = (int) auxiliar.charAt(i); // converte para inteiro para obter o codigo ASCII

            // verifica se o caracter é uma letra maiuscula ou acentuada ou espaco em branco
            // para ser valido
            if (!((caracterdoNomeLido >= 65 && caracterdoNomeLido <= 90)
                    || (caracterdoNomeLido >= 192 && caracterdoNomeLido <= 255) || (caracterdoNomeLido == 32))) {
                System.out.println("OPS!! ALGO ESTA ERRADO!! Formato do nome incorreto.");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // importar a classe Scanner para obter dados digitados pele usuario
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Declaracao das variaveis da classe.
        String nomeCliente, agenciaBancaria;
        int numeroContaBanco = 0;
        double saldoConta = 0;

        // Obter dados do usuario
        System.out.println("=====================================================================================");
        System.out.println("Seja Bem Vindo!! \nVamos Comecar?");

        System.out.println("=====================================================================================");

        // -----------Obter o nome do cliente---------------
        do {
            System.out.print("Por favor digite o seu nome:  ");
            nomeCliente = scanner.nextLine();
        } while (!validaNome(nomeCliente));

        // Obter numero da agencia
        System.out.print("Agora insira o numero da sua agencia: ");
        agenciaBancaria = scanner.next();

        //----------- Obter numero da conta ------------
        do {
            try {
                System.out.print("Digite o numero do seu banco: ");
                numeroContaBanco = scanner.nextInt();

                if (numeroContaBanco <= 0) {
                    System.out.println("ERRO Digite um valor valido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ops! Algo esta errado. Digite um numero valido: ");
                scanner.nextLine();
            }
        } while (numeroContaBanco <= 0);

        // -----------mensagem final-----------
        System.out.println("\nOlá ".concat(nomeCliente.toUpperCase())
                + ", obrigado por criar uma conta em nosso banco, sua agência é ".concat(agenciaBancaria) + ", conta "
                + numeroContaBanco + " e seu saldo R$" + saldoConta + " já disponível para saque.");
        System.out.println("=====================================================================================");
        scanner.close();
    }
}
