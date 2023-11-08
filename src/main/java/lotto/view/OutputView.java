package lotto.view;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printfMessage(String message, Object... args) {
        System.out.printf(message, args);
    }
}
