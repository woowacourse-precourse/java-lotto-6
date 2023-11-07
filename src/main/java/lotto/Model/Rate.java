package lotto.Model;

public class Rate {
    private final double rate;
    public Rate(Money money, WinningResult winningResult) {
        this.rate=(getAllMoney(winningResult) * 0.1) / money.getLotto();
    }

    private long getAllMoney(WinningResult winningResult) {
        int result = 1;

        for(Winning winning : Winning.values()) {
            result += winningResult.getWinningCount(winning) * winning.getMoney();
        }
        return result;
    }
    public double getRate() {
        return rate;
    }
}
