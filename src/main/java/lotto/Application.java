package lotto;

import lotto.controller.PurchaseController;
import lotto.controller.PaymentController;
import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = PaymentController.paymentInit();
        Lottos lottos = PurchaseController.purchase(buyer);
    }
}
