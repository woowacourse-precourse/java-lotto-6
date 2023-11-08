package lotto.constant;

public enum MagicNumber {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_COUNT(6),
    RANK_COUNT(5),
    PRICE_UNIT(1000);


    private int number;

    MagicNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
