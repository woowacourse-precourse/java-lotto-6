package lotto;

public class ExceptionHandler {

    private static final String ERROR = "[ERROR] ";

    public static void restartWhenExceptionOccur(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }
}
