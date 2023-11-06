package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.domain.RandomLottoGenerator;
import lotto.service.LottoGameService;
import lotto.view.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(),
                new OutputView(),
                new InputParser(),
                new LottoGameService(new LottoGame(new RandomLottoGenerator())));
        lottoController.run();
    }
}
