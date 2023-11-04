package lotto;

import lotto.controller.LottoGameController;
import lotto.model.Lotto;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView);
        lottoGameController.run();
    }
}
