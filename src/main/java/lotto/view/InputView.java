package lotto.view;

public class InputView {

    public static void println(String message) {
        print(message);
        lineBreak();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void lineBreak() {
        System.out.println();
    }
}
