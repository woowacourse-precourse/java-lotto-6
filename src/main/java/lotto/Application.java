package lotto;

import lotto.controller.LottoGameController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoGameController lottoGameController = new LottoGameController();
            lottoGameController.start();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
