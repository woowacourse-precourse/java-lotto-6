package lotto.domain;

public enum Ranking {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(-1, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    NO_PRIZE(0, 0);

    private final int count;
    private final int prize;

    Ranking(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Ranking getRanking(int matchingCount) {
        for (Ranking rank : Ranking.values()) {
            if (rank.count == matchingCount) {
                return rank;
            }
        }
        return NO_PRIZE;
    }
}
