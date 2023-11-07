package lotto.constant;

public enum LottoConstant {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_LENGTH(6),
    LOTTO_PRICE(1000);

    private final int number;

    LottoConstant(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}