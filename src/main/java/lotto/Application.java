package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        new LottoGameController(new InputView(), new OutputView(), new LottoGameService()).run();
    }
}
