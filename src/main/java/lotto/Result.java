package lotto;

public enum Result {
    THREE(5000, 3), FOUR(50000, 4), FIVE(1500000, 5), FIVE_BONUS(30000000, 5), SIX(2000000000, 6), LOSE(0, 0);

    private final int earnings;
    private final int matchCount;

    Result(int earnings, int matchCount) {
        this.earnings = earnings;
        this.matchCount = matchCount;
    }

    public int getEarnings() {
        return earnings;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
