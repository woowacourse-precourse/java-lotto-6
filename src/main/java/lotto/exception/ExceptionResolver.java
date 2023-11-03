package lotto.exception;

public class ExceptionResolver {

    private ExceptionResolver() {
    }

    public static void resolveProcess(final Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException | IllegalStateException e) {
            printExceptionMessage(e.getMessage());
            resolveProcess(runnable);
        }
    }

    private static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
