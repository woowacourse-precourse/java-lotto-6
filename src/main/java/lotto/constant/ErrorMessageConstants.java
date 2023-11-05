package lotto.constant;

public enum ErrorMessageConstants {
    ERROR_PREFIX("[ERROR] "),
    LINE("\n");

    private final String message;

    ErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
