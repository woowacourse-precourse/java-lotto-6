package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {

    }

    public void run() {
        try {
            Amount amount = InputView.inputAmount();
            System.out.println(amount);
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
        }
    }
}
