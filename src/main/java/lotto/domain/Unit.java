package lotto.domain;

public enum Unit {

    PURCHASE_UNIT(1000);

    private final int unit;

    Unit(int unit) {
        this.unit = unit;
    }

    private int getUnit() {
        return unit;
    }

    public static int getPurchaseNumber(int purchasePrice) {
        return purchasePrice / PURCHASE_UNIT.unit;
    }
}
