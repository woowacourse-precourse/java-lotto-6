package lotto.domain;

public class PurchasePrice {

    private static final int MINIMUM_PURCHASE_PRICE = 1000;

    private final Integer amount;

    public static PurchasePrice of(Integer amount) {
        return new PurchasePrice(amount);
    }

    private PurchasePrice(Integer amount) {
        this.amount = amount;
    }

}
