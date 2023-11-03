package util;

public enum NumberErrorMessage {
    NUMBER_IN_EMPTY("아무것도 입력하지 않았습니다.");

    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}