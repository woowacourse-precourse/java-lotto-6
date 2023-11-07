package lotto;

public enum LottoRevenue {
    MATCHED_3(3, 5000),
    MATCHED_4(4, 50000),
    MATCHED_5(5, 1500000),
    MATCHED_6(6, 2000000000),
    MATCHED_5_WITH_BONUS(7, 30000000);

    private int matchValue;
    private double matchRevenue;

    LottoRevenue(int matchValue, long matchRevenue) {
        this.matchValue = matchValue;
        this.matchRevenue = matchRevenue;
    }

    public int getMatchValue() {
        return matchValue;
    }

    public double getMatchRevenue() {
        return matchRevenue;
    }

    public void increaseRevenue(int increaseCount) {
        matchRevenue = increaseCount * matchRevenue;
    }
}
