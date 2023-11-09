package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.ticket.LottoNumberGenerator;
import lotto.view.input.InputConsoleView;
import lotto.view.output.OutputConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGameController lottoController = new LottoGameController(new LottoNumberGenerator(),
                new InputConsoleView(), new OutputConsoleView());
        lottoController.run();
    }
}