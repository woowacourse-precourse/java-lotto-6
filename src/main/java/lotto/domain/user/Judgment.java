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
        Integer count = 0;
        Integer numOfLotto = 0;

        for (int i = 0; i < SIZE_LOTTO_NUMBERS; i++) {
            numOfLotto = getLottoNumber(lotto, i);

            if (isSameWinNumbers(numOfLotto)) {
                count = count + COUNT_NUMBER;
            }
        }

        return count;
    }

    public Boolean isSameBonusNum(Lotto lotto) {
        Integer numOfLotto = 0;

        for (int i = 0; i < SIZE_LOTTO_NUMBERS; i++) {
            numOfLotto = getLottoNumber(lotto, i);

            if (isSameBonusNumber(numOfLotto)) {
                return true;
            }
        }

        return false;
    }

    private Boolean isSameBonusNumber(Integer numOfLotto) {
        return lottoTargetNumResults.isSameBonusNum(numOfLotto, BONUS_NUM_INDEX);
    }

    private Integer getLottoNumber(Lotto lotto, int i) {
        return lotto.getNumber(i);
    }

    private Boolean isSameWinNumbers(Integer numOfLotto) {
        return lottoTargetNumResults.isSameWinNums(numOfLotto);
    }
}
