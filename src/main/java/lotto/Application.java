package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        InputProcessor inputProcessor = new InputProcessor();
        LottoService lottoService = new LottoService(new LottoIssuer(new RandomLottoNumberGenerator()), new WinningRankCalculator(), new ProfitRateCalculator());

        LottoController lottoController = new LottoController(outputView, inputView, inputProcessor, lottoService);
        lottoController.play();
    }
}
