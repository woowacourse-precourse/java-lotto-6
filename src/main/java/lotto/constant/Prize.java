package lotto.constant;

public enum Prize {

    THREE("5000"),
    FOUR("50000"),
    FIVE("1500000"),
    BONUS("30000000"),
    SIX("2000000000");

    private final String value;

    Prize(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public int findMatchingValue() {
        return getPrize();
    }

    private int getPrize() {
        return Integer.parseInt(value);
    }

}
