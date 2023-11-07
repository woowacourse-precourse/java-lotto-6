package lotto.model;

import static lotto.constant.ErrorMessage.NOT_MATCHING_WITH_WINNING_LOTTO;
import static lotto.constant.ErrorMessage.OWNER_ALREADY_MATCH_WITH_WINNING_LOTTO;

import lotto.dto.RateOfReturn;
import lotto.dto.WinningStatistics;

public class LottoGameManager {
    private final LottoOwner lottoOwner;
    private final WinningLotto winningLotto;
    private boolean isEnd = false;

    private LottoGameManager(LottoOwner lottoOwner, WinningLotto winningLotto) {
        this.lottoOwner = lottoOwner;
        this.winningLotto = winningLotto;
    }

    public static LottoGameManager of(LottoOwner lottoOwner, WinningLotto winningLotto) {
        return new LottoGameManager(lottoOwner, winningLotto);
    }

    public void matchLottosWithWinningLotto() {
        if (isEnd) {
            throw new IllegalStateException(OWNER_ALREADY_MATCH_WITH_WINNING_LOTTO.toString());
        }
        isEnd = lottoOwner.matchLottosWithWinningLotto(winningLotto);
    }

    public WinningStatistics getWinningStatistics() {
        if(!isEnd) {
            throw new IllegalStateException(NOT_MATCHING_WITH_WINNING_LOTTO.toString());
        }
        return lottoOwner.getWinningStatistics();
    }

    public RateOfReturn getRateOfReturn() {
        return lottoOwner.convertResultToRateOfReturn();
    }
}
