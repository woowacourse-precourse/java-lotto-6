package lotto;

public enum Unit {
    PURCHASE_AMOUNT_UNIT(1000),
    ZERO(0);

    int unit;

    Unit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
