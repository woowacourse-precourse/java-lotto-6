package lotto.domain;

public enum LottoRank {
    FIRST_PLACE(1, 2_000_000_000L),
    SECOND_PLACE(2, 30_000_000L),
    THIRD_PLACE(3, 1_500_000L),
    FOURTH_PLACE(4, 50_000L),
    FIFTH_PLACE(5, 5_000L);

    private final int rank;
    private final long prize;

    LottoRank(int rank, long prize) {
        this.rank = rank;
        this.prize = prize;
    }
}
