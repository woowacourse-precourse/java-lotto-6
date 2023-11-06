package lotto.module.result;

import lotto.module.domain.lotto.Lotto;
import lotto.module.domain.lotto.WinningLotto;
import lotto.module.store.LottoPrizeTable;

import java.util.List;

/**
 * 구매한 로또 당첨 여부 확인 클래스
 */
public class LottoResultChecker {
    private final LottoResult lottoResult;

    public LottoResultChecker(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoResult getResult(List<Lotto> userLottoTicket, WinningLotto winningLotto) {
        for (Lotto lotto : userLottoTicket) {
            int matchCount = winningLotto.valuesContains(lotto);
            checkFifthPlace(matchCount);
            checkFourthPlace(matchCount);
            checkThirdPlace(matchCount);
            checkSecondPlace(winningLotto, lotto, matchCount);
            checkFirstPlace(winningLotto, lotto, matchCount);
        }

        return lottoResult;
    }

    private void checkFifthPlace(int matchCount) {
        if (matchCount == LottoPrizeTable.FIFTH_PLACE.getMatchCount()) {
            lottoResult.add(LottoPrizeTable.FIFTH_PLACE.getRank());
        }
    }

    private void checkFourthPlace(int matchCount) {
        if (matchCount == LottoPrizeTable.FOURTH_PLACE.getMatchCount()) {
            lottoResult.add(LottoPrizeTable.FOURTH_PLACE.getRank());
        }
    }

    private void checkThirdPlace(int matchCount) {
        if (matchCount == LottoPrizeTable.THIRD_PLACE.getMatchCount()) {
            lottoResult.add(LottoPrizeTable.THIRD_PLACE.getRank());
        }
    }

    private void checkSecondPlace(WinningLotto winningLotto, Lotto lotto, int matchCount) {
        if (matchCount == LottoPrizeTable.SECOND_PLACE.getMatchCount() && winningLotto.isMatchesBonusNumber(lotto)) {
            lottoResult.add(LottoPrizeTable.SECOND_PLACE.getRank());
        }
    }

    private void checkFirstPlace(WinningLotto winningLotto, Lotto lotto, int matchCount) {
        if (matchCount == LottoPrizeTable.FIRST_PLACE.getMatchCount() && !winningLotto.isMatchesBonusNumber(lotto)) {
            lottoResult.add(LottoPrizeTable.FIRST_PLACE.getRank());
        }
    }

}
