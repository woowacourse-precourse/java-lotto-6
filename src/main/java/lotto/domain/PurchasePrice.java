package lotto.domain;

public class PurchasePrice {
    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int getPurchaseCount() {
        return purchasePrice / 1000;
    }

    private void validate(int price) {
        checkDivideByPriceUnit(price);
    }

    private void checkDivideByPriceUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입 금액을 입력해 주세요.");
        }
    }
}
