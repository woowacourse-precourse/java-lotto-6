package lotto.controller;

import lotto.model.Deposit;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
    }

    public Deposit makeDeposit() {
        while (true) {
            try {
                String purchaseAmount = InputView.askPurchaseAmount();
                return new Deposit(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
