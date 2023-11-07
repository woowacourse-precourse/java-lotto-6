package lotto.model;

public class ProfitRate {

    private int profitRate;

    public void calculate(int reward, int purchaseAmount) {
        profitRate = reward / purchaseAmount;
    }
}
