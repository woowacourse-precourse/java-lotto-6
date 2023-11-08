package lotto.utils;

public class ErrorMessage extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public ErrorMessage(String message) {
        super();
        System.out.println(String.format(ERROR_MESSAGE, message));
    }
}