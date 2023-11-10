package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.start();
    }
}
