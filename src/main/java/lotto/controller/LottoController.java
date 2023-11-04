package lotto.controller;

import lotto.domain.Lottos;

public class LottoController {
    private final LottoMarket lottoMarket = new LottoMarket();
    private final LottoCompareSite lottoCompareSite = new LottoCompareSite();

    public void play() {
        lottoMarket.enter();
        Lottos lottos = lottoMarket.goOut();
        lottoCompareSite.access(lottos);
    }
}
