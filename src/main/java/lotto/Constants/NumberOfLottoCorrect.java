package lotto.Constants;

public enum NumberOfLottoCorrect {
    TWO_LESS_MATCHES(0, 0), THREE_MATCHES(5_000, 3), FOUR_MATCHES(50_000, 4), FIVE_MATCHES(
        1_500_000, 5), FIVE_BONUS_MATCHES(30_000_000, 6), SIX_MATCHES(2_000_000_000, 6);

    private final Integer winningAmount;
    private final Integer matchCount;

    NumberOfLottoCorrect(int winningAmount, int matchCount) {
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
