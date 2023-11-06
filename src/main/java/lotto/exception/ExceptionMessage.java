package lotto.exception;

public enum ExceptionMessage {

    INVALID_PURCHASE_AMOUNT_MESSAGE("금액은 1000의 배수여야 합니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 숫자는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 숫자는 중복이면 안됩니다"),
    INVALID_LOTTO_NUMBER_RANGE("로또 숫자는 1 이상 45이하여야 합니다.");

    public final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
