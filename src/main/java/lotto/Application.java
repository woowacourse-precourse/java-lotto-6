package lotto;

import lotto.controller.LottoController;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.winning.LottoWinningSetPicker;
import lotto.domain.generator.LottoManualGenerator;
import lotto.service.LottoProfitCalculatorService;
import lotto.service.LottoStoreService;
import lotto.service.LottoWinningRankingCountService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();
        LottoWinningSetPicker lottoWinningSetPicker = new LottoWinningSetPicker();
        LottoStoreService lottoStoreService = new LottoStoreService(lottoAutoGenerator, lottoManualGenerator);
        LottoWinningRankingCountService lottoWinningRankingCountService = new LottoWinningRankingCountService();
        LottoProfitCalculatorService lottoProfitCalculatorService = new LottoProfitCalculatorService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoStoreService, lottoWinningSetPicker, lottoWinningRankingCountService, lottoProfitCalculatorService);
        lottoController.run();
    }
}
