package lotto;

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
        double result = (double) totalWinningAccount / (double) paymentAccount * PERCENT;
        return Math.round(result * 10) / 10.0;
    }
}
