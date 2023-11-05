package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoMainController {
    private LottoMainController() {
    }

    public static void start() {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);
        Lotto jackpotNumber = JackpotController.requestJackpotNumbers();
    }
}
