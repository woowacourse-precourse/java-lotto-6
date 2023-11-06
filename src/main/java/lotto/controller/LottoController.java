package lotto.controller;

import lotto.service.LotteryService;
import lotto.service.Service;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final Service service;

    public LottoController(final View view, final Service service) {
        this.view = view;
        this.service = service;
    }

    public static LottoController from(final View view) {
        return new LottoController(view, LotteryService.create());
    }

    public void run() {
        String inputPurchaseAmount = view.askPurchaseAmount();
        service.buyLottery(inputPurchaseAmount);
        view.close();
    }
}
