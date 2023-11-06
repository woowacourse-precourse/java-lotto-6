package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.domain.num.LottoTargetNumResults;

public class Judgment {
    // TODO: 11/6/23 상수 관리
    private static final Integer SIZE_LOTTO_NUMBERS = 6;
    private static final Integer BONUS_NUM_INDEX = 6;
    private static final Integer COUNT_NUMBER = 1;
    private LottoTargetNumResults lottoTargetNumResults;

    public Judgment(LottoTargetNumResults lottoTargetNumResults) {
        this.lottoTargetNumResults = lottoTargetNumResults;
    }

    public Integer countSameWinNumbers(Lotto lotto) {
        Integer countSameWinNum = 0;
        Integer numOfLotto = 0;

        for (int i = 0; i < SIZE_LOTTO_NUMBERS; i++) {
            numOfLotto = lotto.getNumber(i);

            if (lottoTargetNumResults.isSameWinNums(numOfLotto)) {
                countSameWinNum = countSameWinNum + COUNT_NUMBER;
            }
        }

        return countSameWinNum;
    }

    public Boolean isSameBonusNum(Lotto lotto) {
        Integer numOfLotto = 0;

        for (int i = 0; i < SIZE_LOTTO_NUMBERS; i++) {
            numOfLotto = lotto.getNumber(i);

            if (lottoTargetNumResults.isSameBonusNum(numOfLotto, BONUS_NUM_INDEX)) {
                return true;
            }
        }

        return false;
    }
}
