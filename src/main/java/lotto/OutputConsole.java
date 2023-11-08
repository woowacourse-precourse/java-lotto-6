package lotto;

public class OutputConsole {


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public static void print(Lottos lottos) {
        lottos.print();
    }

    public static void printResult(Lottos lottos, WinningLotto winningLotto) {
        lottos.printResult(winningLotto);
    }

}
