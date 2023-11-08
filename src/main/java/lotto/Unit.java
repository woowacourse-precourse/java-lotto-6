package lotto;

public enum Unit {
    PURCHASE_AMOUNT_UNIT(1000),
    LOTTERY_NUMBER_COUNT(6),
    LOTTERY_MINIMUM_NUMBER(1),
    LOTTERY_MAXIMUM_NUMBER(45),
    ZERO(0),
    ONE(1),
    PERCENTAGE(100);

    int unit;

    Unit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
