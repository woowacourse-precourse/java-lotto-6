package lotto.domain;

import java.util.List;

public class Profit {
    private int profit = 0;
    private float profitRate = 0;

    public void setProfit(GameResult gameResult) {
        List<Ranking> rankings = gameResult.getRankings();

        for (Ranking ranking : rankings) {
            profit += ranking.getPrize();
        }
    }

    public void setProfitRate(Money money) {
        profitRate = (float) profit / money.getMoney() * 100;
    }

    public int getProfit() {
        return profit;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
