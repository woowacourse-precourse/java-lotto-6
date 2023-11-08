package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View(new ConsoleInputView(), new ConsoleOutputView());
        LottoController lottoController = new LottoController(view);
        lottoController.tryLottoSimulation();
    }
}
