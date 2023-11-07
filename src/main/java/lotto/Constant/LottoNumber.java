package lotto.Constant;

public enum LottoNumber {
    MIN_INCLUSIVE(1),
    MAX_INCLUSIVE(45),

    COUNT(6);
    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
