package lotto.enums;

public enum ErrorEnum {
    ERROR_MESSAGE("[ERROR]");

    private final String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
