package lotto.controller;

import lotto.config.InputConfiguration;
import lotto.domain.Purchase;
import lotto.domain.vo.TotalAmount;
import lotto.util.handler.InputHandler;

public class PurchaseController {
    public Purchase processPurchase() {
        // 금액 입력 처리
        InputHandler<Integer> amountInputHandler = InputConfiguration.createAmountInputHandler();
        int amount = amountInputHandler.processInput();
        TotalAmount totalAmount = TotalAmount.from(amount);
        return Purchase.from(totalAmount);
    }
}
