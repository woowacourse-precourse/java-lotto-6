package lotto.exception;

public enum ErrorMessage {
    EMPTY("[ERROR] 값이 비어있습니다. 다시 입력해주세요."),
    ENDS_WITH_DELIMITER("[ERROR] 입력은 쉼표로 끝이 날 수 없습니다. 다시 입력해주세요."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 받습니다. 다시 입력해주세요."),
    INVALID_LOTTO_NUMBER_COUNT_INPUT("[ERROR] 당첨 번호는 6개의 숫자를 입력 받습니다. 다시 입력해주세요."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다. 다시 입력해주세요."),
    INVALID_LOTTO_NUMBER_INPUT("[ERROR] 로또 번호의 숫자 범위는 1~45까지입니다. 다시 입력해주세요."),
    INVALID_INPUT_TYPE("[ERROR] 입력은 숫자만 가능합니다. 다시 입력해주세요.")
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
