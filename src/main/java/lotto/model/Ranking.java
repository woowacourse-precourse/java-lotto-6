package lotto.model;

public enum Ranking {
    FAIL("", 0, (correct, bonus) -> false),
    FIFTH("3개 일치 (5,000원) - ", 5000, (correct, bonus) -> correct == 3),
    FOURTH("4개 일치 (50,000원) - ", 50000, (correct, bonus) -> correct == 4),
    THIRD("5개 일치 (1,500,000원) - ", 1500000, (correct, bonus) -> correct == 5 && !bonus),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, (correct, bonus) -> correct == 5 && bonus),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000, (correct, bonus) -> correct == 6);

    private String condition;
    private int profit;
    private RankingFunction function;

    private Ranking(String condition, int profit, RankingFunction function) {
        this.condition = condition;
        this.profit = profit;
        this.function = function;
    }

    public static Ranking of(int correct, boolean isBonus) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.function.apply(correct, isBonus)) {
                return ranking;
            }
        }
        return FAIL;
    }

    public int getProfit() {
        return profit;
    }

    public String getCondition() {
        return condition;
    }

    private interface RankingFunction {
        boolean apply(int correct, boolean isBonus);
    }
}


