package lotto.constant;

public enum ErrorMessage {

    NUM_POSITIVE("양의정수만 입력하세요"),
    RANGE("1~45의 숫자만 입력해주세요"),
    EMPTY_NAME("로또 번호가 "),
    LEN_MAX("");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
