package lotto.util;

public enum ExceptionMessageGenerator {
    INSTANCE;
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    public String makeMessage(String message) {
        return ERROR_MESSAGE_HEADER + message;
    }
}
