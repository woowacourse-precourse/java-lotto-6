package lotto.controller;

import lotto.model.Amount;
import lotto.util.Conversion;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private Amount amount;

    public void run() {
        purchase();
    }

    private void purchase() {
        try {
            int money = Conversion.stringToInt(InputView.purchase());
            amount = new Amount(money);
        } catch (IllegalArgumentException exception) {
            OutputView.error(exception.getMessage());
            purchase();
        }
    }
}
