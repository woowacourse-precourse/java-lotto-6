package lotto.constant;

public enum Number {

    LOTTO_NUM_COUNT(6),
    LOTTO_MAX_NUM(45),
    LOTTO_MIN_NUM(1),
    LOTTO_PRICE(1000),
    RANK1_PRIZE(2000000000),
    RANK2_PRIZE(30000000),
    RANK3_PRIZE(1500000),
    RANK4_PRIZE(50000),
    RANK5_PRIZE(5000);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
