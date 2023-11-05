package lotto;

public class User {

    private final int purchaseAmount;
    private int totalWinningAmount = 0;

    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTotalWinningAmount() {
        return totalWinningAmount;
    }

    public void addWinningAmount(int winningAmount) {
        this.totalWinningAmount += winningAmount;
    }
}
