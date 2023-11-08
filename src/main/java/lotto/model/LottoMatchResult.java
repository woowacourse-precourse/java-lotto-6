package lotto.model;

public class LottoMatchResult {
    private final Lotto lotto;
    private final int bonusNumber;

    public LottoMatchResult(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinnerJudge match(Lotto playerNumber) {
        int matchNum = playerNumber.matchingNumbers(lotto);
        boolean isBonus = playerNumber.containNumber(bonusNumber);

        return WinnerJudge.match(matchNum, isBonus);
    }
}
