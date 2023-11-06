package lotto;

public enum LottoConstance {
    MIN_NUMBER_LOTTO_RANGE(1),
    MAX_NUMBER_LOTTO_RANGE(45),
    LOTTO_SIZE(6),
    MIN_PAYMENT(1000),
    MAX_PAYMENT(100000),
    FIRST_WINING_COUNT(6),
    SECOND_AND_THIRD_WINING_COUNT(5),
    FOURTH_WINING_COUNT(4),
    FIFTY_WINING_COUNT(3);
    private final int number;

    LottoConstance(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }

}
