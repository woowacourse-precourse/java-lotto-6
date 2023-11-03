package lotto.domain;

public enum LottoNumber {
    EXACT_LOTTO_COUNTS(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
