package lotto.domain;

public class LottoResult {

    private int matchingCount;
    private boolean hasBonusNumber;

    public LottoResult(int matchingCount, boolean hasBonusNumber) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }
}
