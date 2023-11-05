package lotto.domain;

public enum Unit {

    PURCHASE_UNIT(1000),
    ZERO(0);

    private final int unit;

    Unit(int unit) {
        this.unit = unit;
    }

    public static int calculateLottoTicketCanPurchase(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return purchasePrice / PURCHASE_UNIT.unit;
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % PURCHASE_UNIT.unit != ZERO.unit) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getValue() {
        return unit;
    }
}
