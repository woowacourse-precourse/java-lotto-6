package lotto;

import lotto.controller.LottoController;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoManualGenerator;
import lotto.service.LottoProfitService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningRankingService;
import lotto.service.LottoWinningSetService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();
        LottoWinningSetService lottoWinningSetPicker = new LottoWinningSetService();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(lottoAutoGenerator, lottoManualGenerator);
        LottoWinningRankingService lottoWinningRankingService = new LottoWinningRankingService();
        LottoProfitService lottoProfitService = new LottoProfitService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoPurchaseService, lottoWinningSetPicker, lottoWinningRankingService, lottoProfitService);
        lottoController.run();
    }
}
