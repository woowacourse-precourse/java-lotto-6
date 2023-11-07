package lotto.domain;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_CONTAINS_BONUS;
import static lotto.constants.LottoConfiguration.SECOND_PRIZE_COUNT;

import lotto.constants.LottoPrize;
import lotto.exception.LottoException;

public class WinLotto {

    private final Lotto winLotto;
    private final int bonus;

    public WinLotto(Lotto winLotto, int bonus) {
        this.winLotto = winLotto;
        containsNumberCheck(winLotto, bonus);
        this.bonus = bonus;
    }

    private void containsNumberCheck(Lotto winLotto, int bonus) {
        if (winLotto.isContainsNumber(bonus)) {
            throw LottoException.of(ERROR_LOTTO_CONTAINS_BONUS);
        }
    }

    public LottoPrize lottoComparison(Lotto otherLotto) {
        int rank = (int) winLotto.lottoNumberComparison(otherLotto);

        // 2등 케이스 확인
        if (rank == SECOND_PRIZE_COUNT.getConfig() && otherLotto.isContainsNumber(bonus)) {
            return LottoPrize.SECOND_PRIZE;
        }

        return LottoPrize.getResultByMatchedNumbers(rank);
    }
}
