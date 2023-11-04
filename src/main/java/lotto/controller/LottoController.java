package lotto.controller;

public class LottoController {
    private final LottoMarket lottoMarket = new LottoMarket();

    public void play() {
        lottoMarket.enter();
    }
}
