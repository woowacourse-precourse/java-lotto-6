package lotto.common;

public enum LottoNumberRange {
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45);

    private int number;

    private LottoNumberRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
