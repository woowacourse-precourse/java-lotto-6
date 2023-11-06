package lotto.domain;

public class LottoResult {
    private boolean isWinner;
    private int matchingCount;

    public LottoResult(boolean isWinner, int matchingCount) {
        this.isWinner = isWinner;
        this.matchingCount = matchingCount;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
