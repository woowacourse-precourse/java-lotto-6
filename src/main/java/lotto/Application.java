package lotto;

import lotto.controller.LottoGameController;
import lotto.model.NumberGenerator;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoGameController lottoGameController = new LottoGameController(inputView, numberGenerator);
        lottoGameController.run();
    }
}
