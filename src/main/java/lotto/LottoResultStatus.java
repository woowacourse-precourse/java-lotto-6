package lotto;

public enum LottoResultStatus {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_AND_BONUS_MATCH(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    private final int matchingNumbers;
    private final boolean bonusNumbers;
    private final int winningAmount;

    LottoResultStatus(int matchingNumbers, boolean bonusNumbers, int winningAmount) {
        this.matchingNumbers = matchingNumbers;
        this.bonusNumbers = bonusNumbers;
        this.winningAmount = winningAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean hasBonusNumber() {
        return bonusNumbers;
    }
}
