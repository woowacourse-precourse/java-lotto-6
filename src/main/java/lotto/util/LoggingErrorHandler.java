package lotto.util;

public class LoggingErrorHandler implements ErrorHandler {
    @Override
    public void handle(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }
}
