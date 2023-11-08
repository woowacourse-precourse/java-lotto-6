package lotto;

import lotto.controller.LottoController;
import lotto.domain.model.generator.LottoIssuer;
import lotto.domain.model.result.ProfitRateCalculator;
import lotto.domain.model.generator.RandomLottoNumberGenerator;
import lotto.domain.model.result.WinningRankCalculator;
import lotto.service.LottoService;
import lotto.view.InputProcessor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        InputProcessor inputProcessor = new InputProcessor();
        LottoService lottoService = new LottoService(new LottoIssuer(new RandomLottoNumberGenerator()), new WinningRankCalculator(), new ProfitRateCalculator());

        LottoController lottoController = new LottoController(outputView, inputView, inputProcessor, lottoService);
        lottoController.play();
    }
}
