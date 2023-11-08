package lotto.domain.Result;

public enum Rank {
    FIFTHRANK(3, 5_000, "3개 일치 (5,000원) - %s개\n"),
    FORTHRANK(4, 50_000, "4개 일치 (50,000원) - %s개\n"),
    THIRDRANK(5, 1_500_000, "5개 일치 (1,500,000원) - %s개\n"),
    SECONDRANK(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n"),
    FIRSTRANK(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %s개\n");

    private final int matchNumbers;
    private final int rankPrize;
    private final String rankOutput;

    Rank(int matchNumbers, int rankPrize, String rankOutput) {
        this.matchNumbers = matchNumbers;
        this.rankPrize = rankPrize;
        this.rankOutput = rankOutput;
    }

    public int getRankPrize() {
        return this.rankPrize;
    }

    public String getRankOutput() {
        return this.rankOutput;
    }
}
