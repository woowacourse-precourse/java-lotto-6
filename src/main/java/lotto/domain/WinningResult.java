package lotto.domain;

public class WinningResult {
    private final Lotto lotto;
    private final int bonusnumber;

    public WinningResult(Lotto lotto, int bonusnumber) {
        this.lotto = lotto;
        this.bonusnumber = bonusnumber;
    }

    public Ranking match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusnumber);
        return Ranking.valueOf(countOfMatch, bonusCheck);
    }
}
