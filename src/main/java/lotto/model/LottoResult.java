package lotto.model;

public enum LottoResult {
    FIRST_PRIZE(1, 2_000_000_000),
    SECOND_PRIZE(2, 30_000_000),
    THIRD_PRIZE(3, 1_500_000),
    FORTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(5, 5_000),
    NO_PRIZE(0, 0);


    private final int rank;
    private final long prize;

    LottoResult(int rank, long prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }
}
