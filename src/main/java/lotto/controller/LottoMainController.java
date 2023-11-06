package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.domain.prize.FinalResults;
import lotto.domain.prize.Prize;
import lotto.dto.FinalResultResponse;
import lotto.view.output.FinalResultWriter;

public class LottoMainController {
    private LottoMainController() {
    }

    public static void start() {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);
        Prize prize = PrizeController.requestJackpotNumbers();

        FinalResults finalResults = FinalResultController.generateFinalResult(lottos, prize);
        FinalResultResponse finalResultResponse = FinalResultController.responseFinalResult(buyer, finalResults);

        FinalResultWriter.responseMatchingResult(finalResultResponse);
        FinalResultWriter.responseTotalYield(finalResultResponse);
    }
}
