package lotto.controller;

import lotto.domain.LottoPrize;
import lotto.domain.LottoProfit;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.view.OutputView;

public class LottoMainController {

    private final OutputView outputView;
    private final LottoPurchaseController lottoPurchaseController;
    private final LottosController lottosController;
    private final LottoWinningNumbersController lottoWinningNumbersController;
    private final LottoPrizeController lottoPrizeController;
    private final LottoProfitController lottoProfitController;

    public LottoMainController() {
        outputView = new OutputView();
        lottoPurchaseController = new LottoPurchaseController();
        lottosController = new LottosController();
        lottoWinningNumbersController = new LottoWinningNumbersController();
        lottoPrizeController = new LottoPrizeController();
        lottoProfitController = new LottoProfitController();
    }

    public void play() {
        LottoPurchase lottoPurchase = lottoPurchaseController.getLottoPurchase();
        Lottos lottos = lottosController.getLottos(lottoPurchase);
        printLottoNumbers(lottos);

        LottoWinningNumbers lottoWinningNumbers = lottoWinningNumbersController.getLottoWinningNumbers();
        LottoPrize lottoPrize = lottoPrizeController.getLottoPrize(lottos, lottoWinningNumbers);
        printLottoPrize(lottoPrize);

        LottoProfit lottoProfit = lottoProfitController.getLottoProfit(lottoPrize, lottoPurchase);
        printLottoProfit(lottoProfit);
    }

    public void printLottoNumbers(Lottos lottos) {
        outputView.printLottoNumbers(lottos);
    }

    public void printLottoPrize(LottoPrize lottoPrize) {
        outputView.printLottoPrize(lottoPrize);
    }

    public void printLottoProfit(LottoProfit lottoProfit) {
        outputView.printLottoProfit(lottoProfit);
    }
}
