package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final LottoGame lottoGame = new LottoGame();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {

        LottoController lottoController = new LottoController(lottoGame, inputView, outputView);
        lottoController.run();

    }
}
