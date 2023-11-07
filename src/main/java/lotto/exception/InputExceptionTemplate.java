package lotto.exception;

public class InputExceptionTemplate {

    public static final String ERROR = "[ERROR] ";

    public <T> T run(final InputCallback<T> callback) {
        return run(callback, null);
    }

    public <T> T run(final InputCallback<T> callback, final String message) {
        return executeWithCallback(callback, message);
    }

    private <T> T executeWithCallback(final InputCallback<T> execution, final String message) {
        while (true) {
            try {
                return execution.execute();
            } catch (IllegalArgumentException exception) {
                System.out.printf(ERROR + pickMessage(exception, message));
            }
        }
    }

    private String pickMessage(final Exception exception, final String message) {
        if (message == null) {
            return exception.getMessage();
        }
        return message;
    }
}
