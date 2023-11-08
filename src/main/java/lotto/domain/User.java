package lotto.domain;

public class User {
    private final int amount;

    public User(int purchaseAmount) {
        this.amount = purchaseAmount;
    }

    public int getAmount() {
        return amount;
    }
}
