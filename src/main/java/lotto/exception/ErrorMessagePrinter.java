package lotto.exception;

public class ErrorMessagePrinter {
    private ErrorMessagePrinter() {
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
