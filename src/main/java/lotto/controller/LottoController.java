package lotto.controller;

import lotto.model.Purchase;
import lotto.util.Conversion;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private Purchase purchase;

    public void run() {
        payMoney();
    }

    private void payMoney() {
        try {
            int money = Conversion.stringToInt(InputView.purchase());
            purchase = new Purchase(money);
        } catch (IllegalArgumentException exception) {
            OutputView.error(exception.getMessage());
            payMoney();
        }
    }
}
