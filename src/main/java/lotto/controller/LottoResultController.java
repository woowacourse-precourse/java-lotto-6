package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.LottoConstant;

public class LottoResultController {
    private final LottoResult lottoResult;

    public LottoResultController(WinningLotto winningLotto, List<Lotto> lottos) {
        this.lottoResult = lottoResultGenerating(winningLotto, lottos);
    }

    private LottoResult lottoResultGenerating(WinningLotto winningLotto, List<Lotto> lottos) {
        int payment = lottos.size() * LottoConstant.PRICE_UNIT;
        return new LottoResult(payment, winningLotto, lottos);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
