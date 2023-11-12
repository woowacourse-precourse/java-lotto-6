package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
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
