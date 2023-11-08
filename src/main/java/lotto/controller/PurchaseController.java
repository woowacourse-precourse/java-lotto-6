package lotto.controller;

import lotto.config.InputConfiguration;
import lotto.domain.LottoPurchase;
import lotto.util.handler.InputHandler;
import lotto.vo.TotalAmount;

public class PurchaseController {
    public LottoPurchase processPurchase() {
        TotalAmount totalAmount = InputHandler.processInput(
                InputConfiguration.createAmountInputHandler(),
                TotalAmount::from
        );

        return LottoPurchase.from(totalAmount);
    }
}
