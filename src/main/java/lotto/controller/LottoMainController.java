package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;

public class LottoMainController {
    private LottoMainController() {
    }

    public static void start() {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);

        Lotto jackpotNumber = JackpotController.requestJackpotNumbers();
    }
}
