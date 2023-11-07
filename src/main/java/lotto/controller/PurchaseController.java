package lotto.controller;

import lotto.config.InputConfiguration;
import lotto.domain.Purchase;
import lotto.util.handler.InputHandler;
import lotto.vo.TotalAmount;

public class PurchaseController {
    public Purchase processPurchase() {
        TotalAmount totalAmount = InputHandler.processInput(
                InputConfiguration.createAmountInputHandler(),
                TotalAmount::from
        );

        return Purchase.from(totalAmount);
    }
}
