package lotto.constant;

public enum LottoConstant {
    FIRST(2000000000, 3),
    SECOND(30000000, 3),
    THIRD(1500000, 3),
    FOURTH(50000, 3),
    FIFTH(5000, 3),
    LOTTO_PRICE(1000);

    private final int value;
    private int count;

    LottoConstant(int value, int count) {
        this.value = value;
        this.count = count;
    }

    LottoConstant(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public int number() {
        return this.count;
    }
}
