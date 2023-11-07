package lotto.domain;

public enum LottoWinningRanking {
    NONE(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final int matchedNumberCount;
    private final boolean needsBonusNumber;
    private final long winningAmount;

    LottoWinningRanking(final int matchedNumberCount, final long winningAmount) {
        this(matchedNumberCount, false, winningAmount);
    }

    LottoWinningRanking(final int matchedNumberCount, final boolean needsBonusNumber, final long winningAmount) {
        this.matchedNumberCount = matchedNumberCount;
        this.needsBonusNumber = needsBonusNumber;
        this.winningAmount = winningAmount;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean getNeedsBonusNumber() {
        return needsBonusNumber;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
