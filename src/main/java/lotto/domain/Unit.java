package lotto.domain;

public enum Unit {

    PURCHASE_UNIT(1000),

    ZERO(0);
    private final int unit;

    Unit(int unit) {
        this.unit = unit;
    }

    public static int getPurchaseNumber(int purchasePrice) {
        if (purchasePrice % PURCHASE_UNIT.unit != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해야 합니다.");
        }
        return purchasePrice / PURCHASE_UNIT.unit;
    }
}
