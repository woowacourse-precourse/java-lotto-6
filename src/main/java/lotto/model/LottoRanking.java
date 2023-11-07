package lotto.model;

public enum LottoRanking {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 0),
    THIRD(5, 1_500_000, 0),
    FORTH(4, 50_000, 0),
    FIFTH(3, 5_000, 0);

    private final int matchCount;
    private final int prizeMoney;
    private int count;

    LottoRanking(int matchCount, int prizeMoney, int count) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int count() {
        return count;
    }

    public void addCount(LottoRanking lottoRanking) {
        lottoRanking.count++;
    }
}
