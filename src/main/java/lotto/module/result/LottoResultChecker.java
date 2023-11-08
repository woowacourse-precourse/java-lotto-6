package lotto.module.result;

import lotto.module.domain.TotalPrize;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.WinningLotto;

import java.util.List;

import static lotto.module.rank.LottoPrizeTable.*;

/**
 * 구매한 로또 당첨 여부 확인 클래스
 */
public class LottoResultChecker {
    private LottoResult lottoResult;

    private LottoResultChecker() {
    }

    public static LottoResultChecker newInstance() {
        return new LottoResultChecker();
    }

    public LottoResult getResult(List<Lotto> userLottoTicket, WinningLotto winningLotto) {
        lottoResult = LottoResult.newInstance();

        for (Lotto lotto : userLottoTicket) {
            int matchCount = winningLotto.getIncludedNumbersCount(lotto);
            check(matchCount, lotto, winningLotto);
        }

        return lottoResult;
    }

    public TotalPrize getTotalPrize() {
        return lottoResult.getTotalPrize();
    }

    private void check(int matchCount, Lotto lotto, WinningLotto winningLotto) {
        checkFifthPlace(matchCount);
        checkFourthPlace(matchCount);
        checkThirdPlace(matchCount);
        checkSecondPlace(winningLotto, lotto, matchCount);
        checkFirstPlace(matchCount);
    }

    private void checkFifthPlace(int matchCount) {
        if (matchCount == FIFTH_PLACE.getMatchCount()) {
            lottoResult.add(FIFTH_PLACE.getRank());
        }
    }

    private void checkFourthPlace(int matchCount) {
        if (matchCount == FOURTH_PLACE.getMatchCount()) {
            lottoResult.add(FOURTH_PLACE.getRank());
        }
    }

    private void checkThirdPlace(int matchCount) {
        if (matchCount == THIRD_PLACE.getMatchCount()) {
            lottoResult.add(THIRD_PLACE.getRank());
        }
    }

    private void checkSecondPlace(WinningLotto winningLotto, Lotto lotto, int matchCount) {
        if (matchCount == SECOND_PLACE.getMatchCount() && winningLotto.isMatchesBonusNumber(lotto)) {
            lottoResult.add(SECOND_PLACE.getRank());
        }
    }

    private void checkFirstPlace(int matchCount) {
        if (matchCount == FIRST_PLACE.getMatchCount()) {
            lottoResult.add(FIRST_PLACE.getRank());
        }
    }

}
