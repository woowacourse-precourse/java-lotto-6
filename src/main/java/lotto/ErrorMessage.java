package lotto;

public enum ErrorMessage {
    ERROR("[ERROR]"),
    LOTTO_WRONG_RANGE_ERROR_MESSAGE(ERROR.get() + "로또 번호는 1~45사이의 숫자입니다."),
    LOTTO_WRONG_SIZE_ERROR_MESSAGE(ERROR.get() + "로또 번호는 6개의 숫자입니다."),
    LOTTO_HAS_DUPLICATION_ERROR_MESSAGE(ERROR.get() + "로또 번호에 중복이 있으면 안됩니다."),
    BONUS_DUPLICATION_ERROR_MESSAGE(ERROR.get() + "보너스 번호는 로또 번호와 중복되면 안됩니다."),
    BONUS_WRONG_RANGE_ERROR_MESSAGE(ERROR.get() + "보너스 번호는 1~45사의 숫자입니다."),
    PAYMENT_NOT_DIVISIBLE_BY_1000(ERROR.get() + "잔돈 없어요. 알맞게 내주세요."),
    PAYMENT_LESS_THAN_1000(ERROR.get() + "로또는 장당 천원 입니다."),
    PAYMENT_MORE_THAN_100000(ERROR.get() + "로또는 한 번에 최대 10만원까지만 구매 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
