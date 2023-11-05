package lotto.constant;

public enum ErrorMessage {
    PREFIX("[ERROR] %s"),

    INDIVISIBLE_AMOUNT(String.format(
            "%d원 단위의 금액을 입력해야 합니다.",
            LottoConstraint.PRICE_PER_LOTTO.getValue()
    )),
    OUT_RANGE_AMOUNT(String.format(
            "%d원 이상, %d원 이하의 금액을 입력해야 합니다.",
            LottoConstraint.MIN_AMOUNT.getValue(),
            LottoConstraint.MAX_AMOUNT.getValue()
    )),

    INVALID_LOTTO_NUMBERS_SIZE(String.format(
            "로또 번호의 개수는 %d개 여야 합니다.",
            LottoConstraint.LOTTO_NUMBER_COUNT.getValue()
    )),
    OUT_RANGE_LOTTO_NUMBER(String.format(
            "로또 숫자는 %d 이상 %d 이하여야 합니다.",
            LottoConstraint.MIN_LOTTO_NUMBER.getValue(),
            LottoConstraint.MAX_LOTTO_NUMBER.getValue()
    )),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, this.message);
    }
}
