package lotto;

public class LottoMachine {
    private final LottoSeller lottoSeller;
    private final LottoJudge lottoJudge;

    public LottoMachine(LottoSeller lottoSeller, LottoJudge lottoJudge) {
        this.lottoSeller = lottoSeller;
        this.lottoJudge = lottoJudge;
    }
}
