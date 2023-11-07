package lotto.exception;

public class ExceptionPrinter {
    public static void printExceptionMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
