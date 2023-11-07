package config;

public enum LottoConst {

    LOTTO_SIZE(6),
    COUNT_INIT(0),
    PRICE_MIN_UNIT(1000),
    RANGE_START(1),
    RANGE_END(45);

    private final int number;

    private LottoConst(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
