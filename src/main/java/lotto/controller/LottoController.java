package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.ExceptionView;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ExceptionView exceptionView = new ExceptionView();

    public void lottoRun() {

    }

    private Lottos buyLotto() {
        int amount;

        while (true) {
            try {
                amount = inputView.inputAmount();
                break;
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }

        return Lottos.fromAmount(amount);
    }

}
