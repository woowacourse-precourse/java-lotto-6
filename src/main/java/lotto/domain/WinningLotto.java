package lotto.domain;

import lotto.util.LottoUtils;

public class WinningLotto {
    private Lotto lotto;
    private int bonus;

    public WinningLotto(String winningLottoStr, String winningBonusStr) {
        this.lotto = convertWinningLotto(winningLottoStr);
        this.bonus = convertWinningBonus(winningBonusStr);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonus() {
        return bonus;
    }

    public Lotto convertWinningLotto(String inputWinningLotto) {
        return new Lotto(LottoUtils.convertInputToLotto(inputWinningLotto));
    }

    public Integer convertWinningBonus(String bonus) {
        return Integer.parseInt(bonus);
    }

    public RankingLotto matchLotto(Lotto myLotto) {
        return RankingLotto.matchRank(myLotto.countMatch(this.getLotto()), myLotto.containMatch(this.getBonus()));
    }
}
