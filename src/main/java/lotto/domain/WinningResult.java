package lotto.domain;

public class WinningResult {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningResult(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto playerRandomNumber) {
        int countOfMatch = playerRandomNumber.countMatch(lotto);
        boolean bonusCheck = playerRandomNumber.containNumber(bonusNumber);
        return Rank.value(countOfMatch, bonusCheck);
    }
}
