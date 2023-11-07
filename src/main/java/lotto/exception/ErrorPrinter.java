package lotto.exception;

public class ErrorPrinter {
    private ErrorPrinter() {
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
