package lotto.model;

import lotto.dto.WinningStatistics;

public class LottoGameManager {
    private final LottoOwner lottoOwner;
    private final WinningLotto winningLotto;

    private LottoGameManager(LottoOwner lottoOwner, WinningLotto winningLotto) {
        this.lottoOwner = lottoOwner;
        this.winningLotto = winningLotto;
    }

    public static LottoGameManager of(LottoOwner lottoOwner, WinningLotto winningLotto) {
        return new LottoGameManager(lottoOwner, winningLotto);
    }

    public WinningStatistics getWinningStatistics() {
        return lottoOwner.matchLottosWithWinningLotto(winningLotto);
    }
}
