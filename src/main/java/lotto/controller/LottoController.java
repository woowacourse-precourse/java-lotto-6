package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Money money;

    public void start() {
        initialize();
    }

    private void initialize() {
        money = putMoney(inputMoney());
        int purchaseCount = money.getPurchaseCount();
        OutputView.showPurchaseCount(purchaseCount);
    }

    private Money putMoney(long money) {
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return putMoney(inputMoney());
        }
    }

    private long inputMoney() {
        try {
            return InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }
}
