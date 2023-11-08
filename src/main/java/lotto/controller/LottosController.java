package lotto.controller;


import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import lotto.service.LottosService;

public class LottosController {

    private final LottosService lottosService;

    public LottosController() {
        this.lottosService = new LottosService();
    }

    public Lottos getLottos(LottoPurchase lottoPurchase) {
        return lottosService.createLottos(lottoPurchase);
    }
}
