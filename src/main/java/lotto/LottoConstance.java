package lotto;

public enum LottoConstance {
    MIN_NUMBER_LOTTO_RANGE(1),
    MAX_NUMBER_LOTTO_RANGE(45),
    LOTTO_SIZE(6),
    MIN_PAYMENT(1000),
    MAX_PAYMENT(100000);

    private final int number;

    LottoConstance(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }

}
