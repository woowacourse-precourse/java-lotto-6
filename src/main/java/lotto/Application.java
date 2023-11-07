package lotto;

import controller.LottoController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(), new OutputView()
        );
        lottoController.buyTickets();
        lottoController.drawLotto();
        lottoController.printWinningStatistics();
    }
}
