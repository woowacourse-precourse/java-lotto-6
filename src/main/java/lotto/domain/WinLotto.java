package lotto.domain;

import static lotto.constants.ErrorConstants.ERROR_LOTTO_CONTAINS_BONUS;

import lotto.exception.LottoException;

public class WinLotto {

    private final Lotto winLotto;
    private final int bonus;

    public WinLotto(Lotto winLotto, int bonus) {
        this.winLotto = winLotto;
        containsNumberCheck(winLotto, bonus);
        this.bonus = bonus;
    }

    /**
     * 당첨 로또 번호에 보너스 번호 중복 확인
     *
     * @param winLotto
     * @param bonus
     */
    private void containsNumberCheck(Lotto winLotto, int bonus) {
        if (winLotto.isContainsNumber(bonus)) {
            throw LottoException.of(ERROR_LOTTO_CONTAINS_BONUS);
        }
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
