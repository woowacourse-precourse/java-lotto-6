package lotto.controller;

import lotto.domain.Lottos;

public class LottoController {
    private final LottoMarket lottoMarket = new LottoMarket();
    private final LottoCompare lottoCompare = new LottoCompare();

    public void play() {
        lottoMarket.enter();
        Lottos lottos = lottoMarket.goOut();
        lottoCompare.access(lottos);
    }
}
