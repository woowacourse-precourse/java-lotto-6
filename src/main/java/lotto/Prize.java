package lotto;

enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int match;
    private final int profit;

    Prize(int match, int profit) {
        this.match = match;
        this.profit = profit;
    }

    public int getMatch() {
        return match;
    }

    public int getProfit() {
        return profit;
    }
}
