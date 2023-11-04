package lotto.controller;

import lotto.model.Amount;
import lotto.util.Conversion;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        try {
            int purchaseAmount = Conversion.stringToInt(InputView.amount());
            Amount amount = new Amount(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            run();
        }
    }
}
