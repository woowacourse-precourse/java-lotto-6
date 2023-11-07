package lotto;

import lotto.controller.LottoController;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.LottoResultCalculator;
import lotto.domain.ProfitCalculator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        LottoService lottoService = new LottoService(randomLottoNumberGenerator);
        LottoResultCalculator resultCalculator = new LottoResultCalculator();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        LottoController lottoController = new LottoController(
                inputView,
                outputView,
                lottoService,
                resultCalculator,
                profitCalculator
        );

        lottoController.playLotto();
    }
}
