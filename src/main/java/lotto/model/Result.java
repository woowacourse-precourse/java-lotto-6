package lotto.model;

import java.util.List;

public class Result {
    private static final String UNIT = "개\n";
    private final List<Ranking> rankings;
    private final double totalProfit;

    public Result(List<Ranking> rankings) {
        this.rankings = rankings;
        this.totalProfit = calculateTotalProfit();
    }

    private double calculateTotalProfit() {
        double profit = 0;
        for (Ranking ranking : rankings) {
            profit += ranking.getProfit();
        }
        return profit / rankings.size();
    }

    public String getNumOfRanks() {
        StringBuilder sb = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getCondition().isEmpty()) continue;
            int cnt = (int) rankings.stream().filter(r -> r.getCondition().equals(ranking.getCondition())).count();
            sb.append(ranking.getCondition() + cnt + UNIT);
        }
        return sb.toString();
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
