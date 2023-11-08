package lotto.constants;

public enum Prize {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000);

    private final int rank;
    private final int matchingBalls;
    private final int money;

    Prize(int rank, int matchingBalls, int money) {
        this.rank = rank;
        this.matchingBalls = matchingBalls;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchingBalls() {
        return matchingBalls;
    }

    public int getMoney() {
        return money;
    }
}