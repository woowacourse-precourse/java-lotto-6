package lotto.controller;

import lotto.view.PurchaseAmountInput;

public class LottoPurchaseController {

    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final PurchaseAmountInput purchaseAmountInput = new PurchaseAmountInput();

    public void start() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        String purchaseAmount = purchaseAmountInput.readLine();
        PurchaseResultController purchaseResultController = new PurchaseResultController();
        purchaseResultController.start(purchaseAmount);
    }

}
