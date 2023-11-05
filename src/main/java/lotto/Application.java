package lotto;

import lotto.controller.BuyerController;
import lotto.controller.PurchaseController;
import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);

    }
}
