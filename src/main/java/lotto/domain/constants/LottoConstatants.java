package lotto.domain.constants;

public enum LottoConstatants {
    LOTTO_NUMBERS_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);


    private final int value;

    LottoConstatants(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
