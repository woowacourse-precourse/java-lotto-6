package lotto.util.constants;

public enum DomainConstants {
    LOTTO_PRICE(1000),
    RANDOM_START_NUMBER(1),
    RANDOM_END_NUMBER(45),
    RANDOM_COUNT_NUMBER(6);

    private final String string;
    private final int intConstant;

    DomainConstants(String string) {
        this.string = string;
        this.intConstant = 0;
    }

    DomainConstants(int intConstants) {
        this.intConstant = intConstants;
        this.string = null;
    }

    public String getString() {
        return string;
    }

    public int getInt() {
        return intConstant;
    }
}
