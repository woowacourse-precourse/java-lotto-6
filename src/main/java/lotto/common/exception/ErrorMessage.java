package lotto.common.exception;

public enum ErrorMessage {
    DUPLICATED_LOTTO_NUMBER("로또 번호는 서로 중복되지 않아야 합니다."),
    INVALID_LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("로또는 1000원 단위로만 구매할 수 있습니다."),
    INVALID_PURCHASE_AMOUNT_RANGE("로또는 1000원 이상 100,000,000원 이하로만 구입할 수 있습니다."),
    DUPLICATED_WINNING_LOTTO_NUMBER_AND_BONUS_BALL("당첨 로또와 보너스볼 번호는 중복되지 않아야 합니다."),
    INVALID_LOTTO_PURCHASE("해당 금액으로 구입할 수 있는 로또의 수량과 실제로 구입한 로또의 수량이 다릅니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValue(Object arg1) {
        return this.value + ": " + arg1;
    }

    public String getValue(Object arg1, Object arg2) {
        return this.value + ": " + arg1 + ", " + arg2;
    }
}
