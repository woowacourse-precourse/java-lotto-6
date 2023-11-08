package lotto.domain;

public enum LottoRank {
    NO_RNAK(0, 0L, "0"),
    FIRST(6, 2000000000L, "2,000,000,000"),
    SECOND(5, 30000000L, "30,000,000"),
    THIRD(5, 1500000L, "1,500,000"),
    FOURTH(4, 50000L, "50,000"),
    FIFTH(3, 5000L, "5,000");

    final private int matchCount;
    final private long prize;
    final private String outputPrize;

    LottoRank(int matchCount, long prize, String outputPrize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.outputPrize = outputPrize;
    }

    public String getOutputPrize() {
        return outputPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}
