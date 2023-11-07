package lotto.config;

public enum ConstNum {
    LENGTH(6),
    LOTTO_MIN(1),
    LOTTO_MAX(45),
    PRICE(1000),
    FIRST_PRIZE(2_000_000_000),
    SECOND_PRIZE(30_000_000),
    THIRD_PRIZE(1_500_000),
    FOURTH_PRIZE(50_000),
    FIFTH_PRIZE(5_000);

    private final Integer num;

    ConstNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }
}
