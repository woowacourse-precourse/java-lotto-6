package lotto.domain;

public class WinningResult {
    private Lotto lotto;
    private int bonusNumber;

    public WinningResult(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranking match(Lotto player) {
        int countOfMatch = player.countMatch(lotto);
        boolean bonusCheck = player.containNumber(bonusNumber);
        return Ranking.valueOf(countOfMatch, bonusCheck);
    }
}
