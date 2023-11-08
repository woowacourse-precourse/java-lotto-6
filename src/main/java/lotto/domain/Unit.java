package lotto.domain;

public enum Unit {

    PURCHASE_UNIT(1000),
    ZERO(0);

    private final int unit;

    Unit(final int unit) {
        this.unit = unit;
    }

    public static int calculateLottoTicketCanPurchase(int purchasePrice) {
        return purchasePrice / PURCHASE_UNIT.unit;
    }

    public int getValue() {
        return unit;
    }
}
