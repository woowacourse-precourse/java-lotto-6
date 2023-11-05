package lotto;

public class User {

    private final int purchaseAmount;
    private int totalWinningAmount = 0;
    private int amountLotto;

    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.amountLotto = this.purchaseAmount/1000;
    }

    public int getAmountLotto() {
        return amountLotto;
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
