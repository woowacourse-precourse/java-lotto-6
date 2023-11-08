package lotto.constant;

public enum LottoConstant {
    SIZE(6),
    RANGE_BEGIN(1),
    RANGE_END(45),
    PRICE(1000);

    private final int number;

    private LottoConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
