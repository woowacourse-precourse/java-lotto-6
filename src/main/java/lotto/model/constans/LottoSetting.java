package lotto.model.constans;

public enum LottoSetting {
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    WINNING_NUMBER_SIZE(6),
    MIN_WINNING_NUMBER(1),
    MAX_WINNING_NUMBER(45),;

    private final int value;

    LottoSetting(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
