package lotto;

public class LottoResult {
    private final int matchedNumbers;
    private final boolean matchedBonusNumber;

    public LottoResult(int matchedNumbers, boolean matchedBonusNumber) {
        this.matchedNumbers = matchedNumbers;
        this.matchedBonusNumber = matchedBonusNumber;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }
}
