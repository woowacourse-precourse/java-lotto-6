package lotto.util;

public enum ExceptionMessage {
    NOT_POSITIVE_INTEGER("양의 정수만 입력 가능합니다."),
    NOT_PROPER_DENOMINATION("구입 금액은 1000원 단위만 가능합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
