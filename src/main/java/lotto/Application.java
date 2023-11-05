package lotto;

import lotto.controller.LottoController;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.profit.LottoProfitCalculator;
import lotto.domain.winning.LottoWinningSetPicker;
import lotto.domain.winning.LottoWinningRankingCalculator;
import lotto.domain.generator.LottoManualGenerator;
import lotto.domain.store.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();
        LottoStore lottoStore = new LottoStore(lottoAutoGenerator, lottoManualGenerator);
        LottoWinningSetPicker lottoWinningSetPicker = new LottoWinningSetPicker();
        LottoWinningRankingCalculator lottoWinningRankingCalculator = new LottoWinningRankingCalculator();
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator();

        LottoController lottoController = new LottoController(inputView, outputView, lottoStore, lottoWinningSetPicker, lottoWinningRankingCalculator, lottoProfitCalculator);
        lottoController.run();
    }
}
