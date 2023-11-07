package lotto.domain;

public enum LottoRule {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_LENGTH(6),
    LOTTO_PRICE(1000),
    ;


    private int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
