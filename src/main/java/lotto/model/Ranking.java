package lotto.model;

public enum Ranking {
    FAIL("", 0),
    FIFTH("3개 일치 (5,000원) - ", 5000),
    FOURTH("4개 일치 (50,000원) - ", 50000),
    THIRD("5개 일치 (1,500,000원) - ", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000);

    private String condition;
    private int profit;

    private Ranking(String condition, int profit) {
        this.condition = condition;
        this.profit = profit;
    }

    public static Ranking of(int correct, boolean isBonus) {
        if (correct == 6) {
            return FIRST;
        } else if (correct == 5 && isBonus) {
            return SECOND;
        } else if (correct == 5) {
            return THIRD;
        } else if (correct == 4) {
            return FOURTH;
        } else if (correct == 3) {
            return FIFTH;
        }
        return FAIL;
    }

    public int getProfit() {
        return profit;
    }

    public String getCondition() {
        return condition;
    }
}
