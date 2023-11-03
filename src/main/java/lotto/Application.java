package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        LottoGameController lottoGameController = new LottoGameController(inputView);
        lottoGameController.run();
    }
}
