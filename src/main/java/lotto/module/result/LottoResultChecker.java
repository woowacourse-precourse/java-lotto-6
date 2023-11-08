package lotto.module.result;

import lotto.module.domain.TotalPrize;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.UserLottoTickets;
import lotto.module.lotto.WinningLotto;

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

    public LottoResult getResult(UserLottoTickets userLottoTicket, WinningLotto winningLotto) {
        lottoResult = LottoResult.newInstance();

        for (Lotto lotto : userLottoTicket.tickets()) {
            int matchCount = winningLotto.getIncludedNumbersCount(lotto);
            checkWinningStatus(matchCount, lotto, winningLotto);
        }

        return lottoResult;
    }

    public TotalPrize getTotalPrize() {
        return lottoResult.getTotalPrize();
    }

    private void checkWinningStatus(int matchCount, Lotto lotto, WinningLotto winningLotto) {
        if (isFirstPlaceWinner(matchCount)) {
            return;
        }
        if (isSecondPlaceWinner(winningLotto, lotto, matchCount)) {
            return;
        }
        if (isThirdPlaceWinner(matchCount)) {
            return;
        }
        if (isFourthPlaceWinner(matchCount)) {
            return;
        }
        if (isFifthPlaceWinner(matchCount)) {
            return;
        }
    }

    private boolean isFirstPlaceWinner(int matchCount) {
        if (matchCount == FIRST_PLACE.getMatchCount()) {
            lottoResult.add(FIRST_PLACE.getRank());
            return true;
        }
        return false;
    }

    private boolean isSecondPlaceWinner(WinningLotto winningLotto, Lotto lotto, int matchCount) {
        if (matchCount == SECOND_PLACE.getMatchCount() && winningLotto.isMatchesBonusNumber(lotto)) {
            lottoResult.add(SECOND_PLACE.getRank());
            return true;
        }
        return false;
    }

    private boolean isThirdPlaceWinner(int matchCount) {
        if (matchCount == THIRD_PLACE.getMatchCount()) {
            lottoResult.add(THIRD_PLACE.getRank());
            return true;
        }
        return false;
    }

    private boolean isFourthPlaceWinner(int matchCount) {
        if (matchCount == FOURTH_PLACE.getMatchCount()) {
            lottoResult.add(FOURTH_PLACE.getRank());
            return true;
        }
        return false;
    }

    private boolean isFifthPlaceWinner(int matchCount) {
        if (matchCount == FIFTH_PLACE.getMatchCount()) {
            lottoResult.add(FIFTH_PLACE.getRank());
            return true;
        }
        return false;
    }

}
