package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.domain.prize.FinalResults;
import lotto.domain.prize.Prize;

public class LottoMainController {
    private LottoMainController() {
    }

    public static void start() {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);
        Prize prize = PrizeController.requestJackpotNumbers();
        FinalResults finalResults = StatisticsController.getFinalResult(lottos, prize);
        
        StatisticsController.publish(buyer, finalResults);
    }
}
