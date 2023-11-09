package lotto.exception.lottonumbersexception;

public enum NumbersErrorMessage {
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 숫자와 일치하는 로또 번호가 있습니다."),
    OUT_OF_NUMBERS_RANGE("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INSUFFICIENT_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    NumbersErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LottoNumbersInputException getException() {
        return new LottoNumbersInputException(message);
    }
}
