package lotto.service;

import lotto.domain.LottoPurchasePrice;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoResultFormatter;

public class LottoService {

    private final Lottos lottos;
    private WinningLotto winningLotto;

    public LottoService(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public void saveLottos(LottoPurchasePrice lottoPurchasePrice) {
        lottos.saveLottos(lottoPurchasePrice);
    }

    public LottoResultFormatter getLottos() {
        return new LottoResultFormatter(lottos.getLottoValues());
    }

    public void saveWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }
}
