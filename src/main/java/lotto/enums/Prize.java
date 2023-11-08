package lotto.enums;

public enum Prize {

    FIRST(2000000000, "2,000,000,000")
    , SECOND(30000000, "30,000,000")
    , THIRD(1500000, "1,500,000")
    , FOURTH(50000, "50,000")
    , FIFTH(5000, "5,000")
    , OTHER(0, "0");

    private final int value;
    private final String printValue;

    Prize(int value, String printValue) {
        this.value = value;
        this.printValue = printValue;
    }

    public int getValue() {
        return value;
    }

    public String getPrintValue() {
        return printValue;
    }
}
