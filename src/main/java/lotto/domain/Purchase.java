package lotto.domain;

public class Purchase {
    private final int amount;

    public Purchase(String amount) {
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }
}