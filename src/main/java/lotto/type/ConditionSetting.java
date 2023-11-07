package lotto.type;

public enum ConditionSetting {
    MIN_NUMBER(1), MAX_NUMBER(45), COUNT(6), PRICE_UNIT(1000);

    private final int value;

    ConditionSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
