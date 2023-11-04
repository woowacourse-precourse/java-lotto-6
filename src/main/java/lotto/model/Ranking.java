package lotto.model;

public enum Ranking {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000);

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
        return null;
    }
}
