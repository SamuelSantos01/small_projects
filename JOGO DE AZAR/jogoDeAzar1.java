import java.security.SecureRandom;
import java.util.Scanner;

public class jogoDeAzar1 {

    private static final SecureRandom randomNumbers = new SecureRandom();
    public static Scanner input = new Scanner(System.in);
    private enum Status {
        Continue, Won, Lost
    };
    private static final int SNAKE = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_SEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        int myPoint = 0;
        Status gameStatus;
        int Soma_dos_dados = RollDice();
        String rodar;

        do{
        limparConsole();
        System.out.println("Teste do git");
        System.out.println(
                "Um jogo popular de azar é um jogo de dados conhecido como craps, que é jogado em cassinos e nas ruas de todo o mundo.\r\n"
                        + //
                        "As regras do jogo são simples e diretas:\r\n\n" + //
                        "Você lança dois dados. Cada dado tem seis faces que contêm um, dois, três, quatro, cinco e seis pontos, \r\n"
                        + //
                        "respectivamente. Depois que os dados param de rolar, a soma dos pontos nas faces viradas para cima é calculada. \r\n"
                        + //
                        "Se a soma for 7 ou 11 no primeiro lance, você ganha. Se a soma for 2, 3 ou 12 no primeiro lance (chamado \r\n"
                        + //
                        "“craps”), você perde (isto é, a “casa” ganha). Se a soma for 4, 5, 6, 8, 9 ou 10 no primeiro lance, essa soma torna-\r\n"
                        + //
                        "-se sua “pontuação”. Para ganhar, você deve continuar a rolar os dados até “fazer sua pontuação” (isto é, obter \r\n"
                        + //
                        "um valor igual à sua pontuação). Você perde se obtiver um 7 antes de fazer sua pontuação.");

        System.out.println("\n===COMEÇOU O JOGO===");
        System.out.println("\nPRIMERO LANÇE");
        System.out.printf("soma dos dados: %d\n\n", Soma_dos_dados);

        switch (Soma_dos_dados) {
            case SEVEN:
            case YO_SEVEN:
                gameStatus = Status.Won;
                break;
            case SNAKE:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.Lost;
                break;

            default:
                gameStatus = Status.Continue;
                myPoint = Soma_dos_dados;
                break;
        }

        while (gameStatus == Status.Continue) {
            
            do{   
                System.out.println("APerte R para arremessar os dados:");
                rodar = input.nextLine();

                 if(rodar.equals("R")){
                    Soma_dos_dados = RollDice();

                    System.out.printf("soma dos dados: %d\n", Soma_dos_dados);

                    if (Soma_dos_dados == myPoint) {
                        gameStatus = Status.Won;
                    } else {
                        if (Soma_dos_dados == SEVEN) {
                            gameStatus = Status.Lost;
                        }
                    }
                 }    
            }while(!rodar.equals("R"));   
        }

        System.out.println("===============");
        if (gameStatus == Status.Won) {
            System.out.println("Você é um cara de muita sorte:");
            System.out.printf("Você ganhou\n\n\n");
        } else {
            if (gameStatus == Status.Lost) {
                System.out.println("Não foi dessa vez:");
                System.out.printf("Você perdeu\n\n\n");
            }
        }
        System.out.println("===============\n\n");

        System.out.println("Você deseja jogar novamente? S ou N");
        rodar = input.nextLine();

    }while(!rodar.equals("N"));
    limparConsole();
        return;
    }

    public static int RollDice() {
        int dado1 = 1 + randomNumbers.nextInt(6);
        int dado2 = 1 + randomNumbers.nextInt(6);
        int sum = dado1 + dado2;
        return sum;
    }

    public static void limparConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}