package lotto.view;

public class OutputView {
    public static void printError(String error) {
        System.out.println(error);
        printEnter();
    }

    public static void printEnter() {
        System.out.println();
    }
}
