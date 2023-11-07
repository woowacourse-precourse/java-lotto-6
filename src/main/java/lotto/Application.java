package lotto;

import lotto.controller.GameController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoStore;
import lotto.io.InputReader;
import lotto.io.OutputWriter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = getGameController();
        gameController.start();
    }

    private static GameController getGameController() {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        InputView inputView = new InputView(writer, reader);
        OutputView outputView = new OutputView(writer);
        LottoStore lottoStore = new LottoStore(new LottoNumberGenerator());
        return new GameController(inputView, outputView, lottoStore);
    }
}
