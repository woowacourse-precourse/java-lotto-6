package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.domain.lottery.Prize;

public class LottoMainController {
    private LottoMainController() {
    }

    public static void start() {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);
        Prize prize = PrizeController.requestJackpotNumbers();

        StatisticsController.publishPrizeResult(lottos, prize);
    }
}
