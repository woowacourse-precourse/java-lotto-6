package lotto.domain;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public int decrease(int lottoPrice) {
        amount -= lottoPrice;
        return amount;
    }

    public int getAmount() {
        return amount;
    }
}