package lotto.Dictionary;

public enum LottoDictionary {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_SIZE(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoDictionary(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
