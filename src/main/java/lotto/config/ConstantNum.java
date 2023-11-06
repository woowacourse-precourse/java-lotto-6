package lotto.config;

public enum ConstantNum {
    PER_PRICE(1000),
    LOTTO_NUMBER_CNT(6),
    LOTTO_BONUS_NUMBER_CNT(1),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private final int num;

    ConstantNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
