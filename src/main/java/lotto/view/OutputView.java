package lotto.view;

public class OutputView {
    public static void printError(String error) {
        System.out.println(error);
        printLineChanging();
    }

    public static void printLineChanging() {
        System.out.println();
    }
}
