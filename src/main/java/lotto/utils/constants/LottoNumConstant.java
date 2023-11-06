package lotto.utils.constants;

public enum LottoNumConstant {
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_SIZE(6),
    LOTTO_AMOUNT_PURCHASE(1000),
    ZERO(0);

    private final int number;

    LottoNumConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
