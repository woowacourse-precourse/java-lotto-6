package lotto;

import controller.LottoController;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View(new ConsoleInputView(), new ConsoleOutputView());
        LottoController lottoController = new LottoController(view);
        lottoController.tryLottoSimulation();
    }
}
