package lotto;

public enum LottoNumber {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    NUMBER_COUNT(6);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
