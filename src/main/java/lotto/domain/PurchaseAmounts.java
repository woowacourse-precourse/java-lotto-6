package lotto.domain;

public class PurchaseAmounts {
    private final int LOTTO_PRICE = 1000;

    private int price;

    public PurchaseAmounts(int price) {
        validatePurchaseAmounts(price);
        this.price = price;
    }

    private void validatePurchaseAmounts(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 장당 1000원 입니다. 다시 입력해주세요.");
        }
    }
}
