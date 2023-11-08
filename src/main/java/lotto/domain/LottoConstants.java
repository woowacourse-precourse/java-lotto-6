package lotto.domain;

public enum LottoConstants {
    SIZE(6),
    RANGE_BEGIN(1),
    RANGE_END(45),
    PRICE(1000);

    private final int number;

    private LottoConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
