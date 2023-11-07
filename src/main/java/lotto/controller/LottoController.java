package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {

    public PurchaseAmount payMoney() {
        int money = 0;
        try {
            money = InputView.inputPurchaseAmount();
            return new PurchaseAmount(money);
        } catch(IllegalArgumentException e) {
            System.out.println("");
            return payMoney();
        }

    }
}
