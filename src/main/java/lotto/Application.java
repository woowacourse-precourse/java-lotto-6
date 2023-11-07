package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.*;
import lotto.domain.*;

public class Application {
    public static void main(String[] args) {
        PaymentController paymentController = new PaymentController();
        LottoController lottoController = new LottoController();
        LottoPaperController lottoPaperController = new LottoPaperController();
        LottoResultController lottoResultController = new LottoResultController();
        PrizeController prizeController = new PrizeController();
        StatisticController statisticController = new StatisticController();

        Payment payment = paymentController.createPayment();
        LottoPaper lottoPaper = lottoPaperController.createLottoPaperWithPayment(payment);
        LottoDraw lottoDraw = lottoController.createLottoDraw();
        LottoResult lottoResult = lottoResultController.createLottoResult(lottoPaper,lottoDraw);
        Prize prize = prizeController.createPrizeWithLottoResult(lottoResult);
        Statistic statistic = statisticController.createStatistic(payment,prize);

        Console.close();
    }
}

