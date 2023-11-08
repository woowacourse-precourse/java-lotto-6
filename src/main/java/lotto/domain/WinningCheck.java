package lotto.domain;

public class WinningCheck {
    private final Lotto lotto;
    private final int bonusball;
    public WinningCheck(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }

    public RankingLotto match(Lotto playerLottoNum) {
        int matchLottoNumber = playerLottoNum.countMatch(lotto);
        boolean containBonusNumber = playerLottoNum.containNumber(bonusball);
        return RankingLotto.getPrize(matchLottoNumber,containBonusNumber);
    }
}
