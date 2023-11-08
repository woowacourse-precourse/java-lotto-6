package lotto.Dictionary;

public enum MoneyDictionary {
    MONEY_MIN_NUMBER(1000),
    MONEY_MAX_NUMBER(100000);

    private final int value;

    MoneyDictionary(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
