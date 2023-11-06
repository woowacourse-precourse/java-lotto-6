package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;

public class LottoController {

    private Amount amount;

    private double getPurchaseAmount() {
        return InputView.getPurchaseAmount();
    }
}
