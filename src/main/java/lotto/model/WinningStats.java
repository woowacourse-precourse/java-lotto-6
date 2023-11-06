package lotto.model;

public class WinningStats {
    private final int matchingNumbers;
    private final int prizeMoney;
    private final int numberOfWins;

    public WinningStats(int matchingNumbers, int prizeMoney, int numberOfWins) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
        this.numberOfWins = numberOfWins;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }
}
