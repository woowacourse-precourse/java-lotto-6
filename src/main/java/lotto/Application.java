package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoProfitService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningRankingService;
import lotto.service.LottoWinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoWinningService lottoWinningSetPicker = LottoWinningService.getInstance();
        LottoPurchaseService lottoPurchaseService = LottoPurchaseService.getInstance();
        LottoWinningRankingService lottoWinningRankingService = LottoWinningRankingService.getInstance();
        LottoProfitService lottoProfitService = LottoProfitService.getInstance();

        LottoController lottoController = new LottoController(inputView, outputView, lottoPurchaseService, lottoWinningSetPicker, lottoWinningRankingService, lottoProfitService);
        lottoController.run();
    }
}
