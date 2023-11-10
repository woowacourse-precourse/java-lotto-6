package lotto.Util;

public enum Size {
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    PAYMENT_UNIT(1000),
    LOTTO_SIZE(6),
    RANK_SIZE(6);
    private final int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
