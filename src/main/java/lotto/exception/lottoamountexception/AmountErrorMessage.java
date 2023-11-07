package lotto.exception.lottoamountexception;

public enum AmountErrorMessage {

    BELOW_MINIMUM_AMOUNT("[ERROR] 로또 구입 금액은 최소 1000원입니다."),
    NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");

    private final String message;

    AmountErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LottoAmountInputException getException() {
        return new LottoAmountInputException(message);
    }
}
