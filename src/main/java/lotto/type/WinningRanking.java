package lotto.type;

public enum WinningRanking {
    FIRST_PLACE(1, 2_000_000_000),
    SECOND_PLACE(2, 30_000_000),
    THIRD_PLACE(3, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(5, 5_000);

    private final int ranking;
    private final double prize;

    WinningRanking(int ranking, double prize) {
        this.ranking = ranking;
        this.prize = prize;
    }
    public int getRanking() {
        return ranking;
    }

    public double getPrize() {
        return prize;
    }

}
