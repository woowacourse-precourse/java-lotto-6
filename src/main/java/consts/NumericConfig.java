package consts;

public enum NumericConfig {

    END_INCLUSIVE(45),
    START_INCLUSIVE(1),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000),
    PERCENT_MULTIPLIER(100);

    private final int number;

    NumericConfig(final int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
