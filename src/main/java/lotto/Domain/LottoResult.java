package lotto.Domain;

public class LottoResult {
    private int matchedNumbers;
    private boolean matchedBonusNumber;

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
