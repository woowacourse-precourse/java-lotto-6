package lotto.domain.enums;

public enum LottoNumberRules {
    EXACT_LOTTO_COUNTS(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    private final int number;

    LottoNumberRules(int number) {
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }
}
