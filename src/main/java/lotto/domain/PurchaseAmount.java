package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    int amount;

    public PurchaseAmount(String inputAmount) {
        int amount = Integer.parseInt(inputAmount);
        validate(amount);
        this.amount = amount;
    }

    public int getPurchaseQuantity() {
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        if ((amount % LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
