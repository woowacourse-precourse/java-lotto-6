package lotto.constant;

public enum LottoSetting {
    DIVISOR(1000),
    MIN_RANDOM_NUMBER(1),
    MAX_RANDOM_NUMBER(45),
    LOTTO_NUMBERS(6);

    private final int value;

    LottoSetting(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
