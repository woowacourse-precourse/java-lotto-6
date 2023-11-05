package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoNumResults;

/**
 * 사용자의 당첨 판단 클래스.
 */
public class Judgment {
    private static final Integer SIZE_LOTTO = 6;
    private static final Integer BONUS_NUM_INDEX = 6;
    private LottoNumResults lottoNumResults;

    public Judgment(LottoNumResults lottoNumResults) {
        this.lottoNumResults = lottoNumResults;
    }

    /**
     * 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
     *
     * @return
     */
    public Integer countSameWinNum(Lotto lotto) {
        Integer countSameWinNum = 0;
        Integer numOfLotto = 0;

        for (int i = 0; i < SIZE_LOTTO; i++) {
            numOfLotto = lotto.getNumber(i);

            if (lottoNumResults.isSameWinNums(numOfLotto)) {
                countSameWinNum = countSameWinNum + 1;
            }
        }
        return countSameWinNum;
    }

    public Boolean isSameBonusNum(Lotto lotto) {
        Integer numOfLotto = 0;

        for (int i = 0; i < SIZE_LOTTO; i++) {
            numOfLotto = lotto.getNumber(i);

            if (lottoNumResults.isSameBonusNum(numOfLotto, BONUS_NUM_INDEX)) {
                return true;
            }
        }

        return false;
    }
}
