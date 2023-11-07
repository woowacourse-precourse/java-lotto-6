package lotto.exception;

public enum ErrorCode {

    EMPTY_VALUE("빈 문자열이 입력되었습니다."),
    NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    INCORRECT_UNIT("1000원 단위로 입력해야합니다."),
    INVALID_LOTTO_SIZE("로또는 6개의 숫자로 이루어져있습니다."),
    INVALID_NUMBER_RANGE("1 ~ 45 사이의 숫자를 입력해야합니다."),
    DUPLICATE_NUMBER("중복되는 숫자가 존재합니다."),
    NOT_FOUND_PURCHASE_LOTTO("구매된 로또가 없습니다."),
    ;


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
