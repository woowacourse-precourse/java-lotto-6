package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.logic.LottoLogic;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoLogic(
                new InputController(new ConsoleView()),
                new LottoController()
        ).run();
    }
}
