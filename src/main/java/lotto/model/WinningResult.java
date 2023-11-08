package lotto.model;


public class WinningResult {

    private final lotto.model.Lotto lotto;
    private final int bonusball;

    public WinningResult(lotto.model.Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }

    public lotto.model.Ranking match(lotto.model.Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusball);
        return Ranking.valueOf(countOfMatch, bonusCheck);
    }
}
