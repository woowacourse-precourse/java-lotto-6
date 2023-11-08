package lotto.dto;

public class LottoMatchResultDto {
    private final int matchCount;
    private final boolean isbonusMatch;
    private final int winningAmount;
    private final int count;

    public LottoMatchResultDto(int matchCount, boolean isbonusMatch, int winningAmount, int count) {
        this.matchCount = matchCount;
        this.isbonusMatch = isbonusMatch;
        this.winningAmount = winningAmount;
        this.count = count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isIsBonusMatch() {
        return isbonusMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getCount() {
        return count;
    }
}
