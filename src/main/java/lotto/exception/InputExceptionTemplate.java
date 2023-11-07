package lotto.exception;

public class InputExceptionTemplate {

    public static final String ERROR = "[ERROR] ";

    public <T> T run(final InputCallback<T> callback) {
        while (true) {
            try {
                return callback.execute();
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR + exception.getMessage());
            }
        }
    }
}
