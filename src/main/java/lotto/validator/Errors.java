package lotto.validator;

public enum Errors {

    NOT_INTEGER("정수 타입이 아닙니다."),
    NULL("값을 입력해야합니다."),
    AMOUNT_NOT_DIVIDED("금액이 나누어 떨어지지 않습니다."),
    NEED_MORE_INPUT("입력한 값의 개수가 부족합니다."),
    DUPLICATE_NUMBER("중복값이 존재합니다."),
    NOT_IN_RANGE("입력한 값이 요구하는 범위에 맞지 않습니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
