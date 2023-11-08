package lotto.controller;

import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;
import lotto.domain.prize.Prize;
import lotto.domain.prize.Statistic;
import lotto.domain.result.LottoResult;

public class GameController {
    private final PaymentController paymentController;
    private final LottoController lottoController;
    private final StatisticController statisticController;

    public GameController() {
        this.paymentController = new PaymentController();
        this.lottoController = new LottoController();
        this.statisticController = new StatisticController();
    }

    public void run() {
        LottoPaper lottoPaper = purchaseLotto();

        LottoResult lottoResult = confirmResult(lottoPaper);
        Prize prize = receivePrize(lottoResult);

        checkYield(lottoPaper, prize);
    }

    private LottoPaper purchaseLotto() {
        Payment payment = paymentController.processPayment();
        return lottoController.purchaseLottoPaper(payment);
    }

    private LottoResult confirmResult(LottoPaper lottoPaper) {
        LottoDraw lottoDraw = lottoController.requestLottoDraw();
        LottoResult lottoResult = lottoController.evaluateLottoResult(lottoPaper, lottoDraw);
        return lottoResult;
    }

    private Prize receivePrize(LottoResult lottoResult) {
        Prize prize = lottoController.calculatePrize(lottoResult);
        return prize;
    }

    private void checkYield(LottoPaper lottoPaper, Prize prize) {
        Statistic statistic = statisticController.calculateStatistic(lottoPaper, prize);
        statisticController.printStatistic(statistic);
    }
}
