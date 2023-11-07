package lotto.exception;

public class InputExceptionTemplate {

    public static final String ERROR = "[ERROR] ";

    public <T> T run(final InputCallback<T> callback) {
        return run(callback, null);
    }

    public <T> T run(final InputCallback<T> callback, final String message) {
        return executeWithCallback(callback, message);
    }

    public void run(final InputVoidCallback callback) {
        run(callback, null);
    }

    public void run(final InputVoidCallback callback, final String message) {
        executeWithCallback(() -> {
            callback.execute();
            return null;
        }, message);
    }

    private <T> T executeWithCallback(InputCallback<T> execution, String message) {
        while (true) {
            try {
                return execution.execute();
            } catch (IllegalArgumentException exception) {
                System.out.printf(ERROR + pickMessage(exception, message));
            }
        }
    }

    private String pickMessage(Exception exception, String message) {
        if (message == null) {
            return exception.getMessage();
        }
        return message;
    }
}
