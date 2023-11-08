package lotto.domain;

public class LottoResult {

    private int matchingNumbers;
    private boolean matchBonusNumber;

    public LottoResult(int matchingNumbers, boolean matchBonusNumber) {
        this.matchingNumbers = matchingNumbers;
        this.matchBonusNumber = matchBonusNumber;
    }
}
