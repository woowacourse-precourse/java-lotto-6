package lotto.common.exception;

public enum LottoErrorMessage {
    DUPLICATED_NUMBER("로또 번호는 서로 중복되지 않아야 합니다."),
    INVALID_LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("로또는 1000원 단위로만 구매할 수 있습니다."),
    INVALID_PURCHASE_AMOUNT_RANGE("로또는 1000원 이상 100,000,000원 이하로만 구입할 수 있습니다.");

    private final String value;

    LottoErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValue(Object invalidArgument) {
        return this.value + ": " + invalidArgument;
    }
}
