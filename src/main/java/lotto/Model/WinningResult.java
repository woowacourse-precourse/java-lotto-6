package lotto.Model;

public class WinningResult {
    private final Lotto lotto;
    private final int bonusBall;

    public WinningResult(Lotto lotto, int bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public LottoRanking match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusBall);
        return LottoRanking.valueOf(countOfMatch, bonusCheck);
    }
}
