package lotto.exception;

public enum ErrorMessage {
    EMPTY("공백은 허용되지 않습니다."),
    INVALID_NUMBER_LENGTH("6개의 번호를 입력해 주세요."),
    DUPLICATED("중복 되지 않은 번호를 입력해주세요."),
    INVALID_NUMBER_RANGE("번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_INPUT("숫자만 입력 가능합니다."),
    INVALID_INPUT_FORMAT("숫자와 쉼표(,)만 입력 가능합니다."),
    INVALID_INPUT_PRICE("로또 1장의 가격은 1,000원 입니다. 1,000원 단위의 숫자를 입력해주세요"),
    ZERO("0은 허용되지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
