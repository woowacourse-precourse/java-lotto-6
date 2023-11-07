package lotto.model;

public class Player {

    private static final int PERCENT = 100;

    private int paymentAccount;
    private int totalWinningAccount;

    public Player() {
        this.paymentAccount = 0;
        this.totalWinningAccount = 0;
    }

    public void savePaymentAccount(int paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public void receiveWinningAccount(int winningAccount) {
        this.totalWinningAccount += winningAccount;
    }

    public double calculateRateOfRevenue() {
        return (double) totalWinningAccount / (double) paymentAccount * PERCENT;
    }

    public int getTotalWinningAccount() {
        return totalWinningAccount;
    }

    public int getPaymentAccount() {
        return paymentAccount;
    }
}
