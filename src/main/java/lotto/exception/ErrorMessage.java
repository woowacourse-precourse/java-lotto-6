package lotto.exception;

public enum ErrorMessage {

    ERROR("[ERROR]"),
    IS_NOT_MULTIPLE_OF_THOUSAND("금액은 1000원 단위로 입력해주세요."),
    EMPTY("값이 입력되지 않았습니다."),
    IS_NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_DELIMITER(",(콤마)만 입력해주세요."),
    DUPLICATE_NUMBERS("중복된 값입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message +" "+ message;
    }

}
