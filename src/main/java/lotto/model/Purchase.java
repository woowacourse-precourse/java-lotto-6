package lotto.model;

public class Purchase {
    private final String amount;

    public Purchase(String amount) {
        this.amount = amount;
    }

    public String getPurchaseAmount() {
        return amount;
    }
}
