package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;

public class LottoController {

    private Amount generateAmount() {
        int amount = InputView.readPurchaseAmount();
        return new Amount(amount);
    }
}
