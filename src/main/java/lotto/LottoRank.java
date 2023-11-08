package lotto;

public enum LottoRank {
    All(6, 2_000_000_000),
    FIVEANDBONUS(5, 30_000_000),
    ONLYFIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
}
