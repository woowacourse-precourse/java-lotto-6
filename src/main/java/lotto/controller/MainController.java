package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;

public class MainController {
    private static final BuyerController buyerController = new BuyerController();
    private static final LottoController lottoController = new LottoController();

    public MainController() {
    }

    public static void run() {
        Buyer buyer = buyerController.getBuyerInfo();
        Lottos lottoTicket = lottoController.createLottoTicket();
        lottoController.showLottoPurchase(lottoTicket);
    }
}
