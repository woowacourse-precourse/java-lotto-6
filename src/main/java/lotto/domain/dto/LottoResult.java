package lotto.domain.dto;

public class LottoResult {

    private final int countOfSameNumber;
    private final boolean matchBonusNumber;

    public LottoResult(int countOfSameNumber, boolean matchBonusNumber) {
        this.countOfSameNumber = countOfSameNumber;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getCountOfSameNumber() {
        return countOfSameNumber;
    }

    public boolean getMatchBonusNumber() {
        return matchBonusNumber;
    }
}
