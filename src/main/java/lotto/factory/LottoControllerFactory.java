package lotto.factory;

import lotto.controller.LottoController;
import lotto.domain.numbergenerator.RandomLottoNumberGenerator;
import lotto.domain.calculator.LottoResultCalculator;
import lotto.domain.calculator.ProfitCalculator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoControllerFactory {

    private LottoControllerFactory() {}

    public static LottoController create() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        LottoService lottoService = new LottoService(randomLottoNumberGenerator);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        return new LottoController(
                inputView,
                outputView,
                lottoService,
                lottoResultCalculator,
                profitCalculator
        );
    }
}
