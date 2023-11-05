package lotto.constant;

public enum LottoSetting {
    DIVISOR(1000),
    MIN_RANDOM_NUMBER(1),
    MAX_RANDOM_NUMBER(45),
    LOTTO_NUMBERS(6),
    REGEX(",");

    private final String value;

    LottoSetting(String value) {
        this.value = value;
    }

    LottoSetting(int value) {
        this.value = String.valueOf(value);
    }


    public int getValue() {
        return Integer.parseInt(value);
    }
}
