package lotto.domain;

public enum MatchingCase {
    THREE_MATCHING(3, 5000),
    FOUR_MATCHING(4, 50000),
    FIVE_MATCHING(5, 1500000),
    FIVE_MATCHING_WITH_BONUS(6, 30000000),
    SIX_MATCHING(6, 2000000000);

    private int matchingValue;
    private int prize;
    private int winningCount;

    MatchingCase(int matchingValue, int prize) {
        this.matchingValue = matchingValue;
        this.prize = prize;
        this.winningCount = 0;
    }

    public int getMatchingValue() {
        return matchingValue;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public void increaseSameCaseCount(int matchingCount, boolean bonusNumberMatching) {
        if (this == FIVE_MATCHING_WITH_BONUS && matchingCount == matchingValue && bonusNumberMatching ) {
            winningCount++;
        }
        if (this != FIVE_MATCHING_WITH_BONUS && matchingCount == matchingValue && !bonusNumberMatching ) {
            winningCount++;
        }
    }
}