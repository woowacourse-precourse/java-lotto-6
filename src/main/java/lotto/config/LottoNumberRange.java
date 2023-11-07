package lotto.config;

public enum LottoNumberRange {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1);

    private int number;

    LottoNumberRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
