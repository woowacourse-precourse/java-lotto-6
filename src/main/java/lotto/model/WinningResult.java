package lotto.model;

public class WinningResult {
    private final int matchingCount;
    private final boolean hasBonusNumber;

    public WinningResult(int matchingCount, boolean hasBonusNumber) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
