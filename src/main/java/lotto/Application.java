package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;

public class Application {
    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();

        LottoController lottoController = new LottoController(consoleInputView);

        lottoController.lottoGamePlay();
    }
}
