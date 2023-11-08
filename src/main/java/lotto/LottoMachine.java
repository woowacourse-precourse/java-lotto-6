package lotto;

import lotto.dto.LottoResult;

public class LottoMachine {
    private final LottoSeller lottoSeller;
    private final LottoJudge lottoJudge;

    public LottoMachine(LottoSeller lottoSeller, LottoJudge lottoJudge) {
        this.lottoSeller = lottoSeller;
        this.lottoJudge = lottoJudge;
    }

    public LottoBundle buyLotto(Money money) {
        return lottoSeller.sell(money);
    }

    public void configureJudge(WinningLotto winningLotto) {
        lottoJudge.configure(winningLotto);
    }

    public LottoResult judge(LottoBundle bundle) {
        return lottoJudge.judge(bundle);
    }
}
