package lotto.values;

public enum LottoInformation {

    LOTTO_PRICE(1000),
    MAX_VALUE(100000),
    START_LOTTO_NUMBER(1),
    LAST_LOTTO_NUMBER(45),
    TOTAL_LOTTO_NUMBER(6),
    TOTAL_BONUS_NUMBER(1);
    private final int value;

    LottoInformation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
