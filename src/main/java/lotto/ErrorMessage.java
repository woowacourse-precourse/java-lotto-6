package lotto;

public enum ErrorMessage {
    ERROR("[ERROR]"),
    LOTTO_WRONG_RANGE_ERROR_MESSAGE(ERROR.get() + "로또 번호는 1~45사이의 숫자입니다."),
    LOTTO_WRONG_SIZE_ERROR_MESSAGE(ERROR.get() + "로또 번호는 6개의 숫자입니다."),
    LOTTO_HAS_DUPLICATION_ERROR_MESSAGE(ERROR.get() + "로또 번호에 중복이 있으면 안됩니다."),
    BONUS_DUPLICATION_ERROR_MESSAGE(ERROR.get() + "보너스 번호는 로또 번호와 중복되면 안됩니다."),
    BONUS_WRONG_RANGE_ERROR_MESSAGE(ERROR.get() + "보너스 번호는 1~45사의 숫자입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
