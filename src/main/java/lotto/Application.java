package lotto;

import lotto.controller.LottoGameController;
import lotto.model.NumberGenerator;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView, numberGenerator);
        lottoGameController.run();
    }
}
