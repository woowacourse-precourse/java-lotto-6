package lotto.model;

import java.util.List;

public class Result {
    private static final String UNIT = "개\n";
    private static final int PRICE_OF_LOTTO = 1000;
    private final List<Ranking> rankings;
    private final double totalProfit;

    public Result(List<Ranking> rankings) {
        this.rankings = rankings;
        this.totalProfit = calculateTotalProfit(rankings.size()*PRICE_OF_LOTTO);
    }

    private double calculateTotalProfit(int payment) {
        double profit = 0;
        for (Ranking ranking : rankings) {
            profit += ranking.getProfit();
        }
        return (profit / payment) * 100;
    }

    public String getNumOfRanks() {
        StringBuilder sb = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.FAIL) {
                continue;
            }
            int cnt = (int) rankings.stream().filter(r -> r == ranking).count();
            sb.append(ranking.getCondition()).append(cnt).append(UNIT);
        }
        return sb.toString();
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
