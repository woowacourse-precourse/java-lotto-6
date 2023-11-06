package lotto.controller;

import lotto.Constants;
import lotto.model.PurchaseAmountValidator;
import lotto.view.InputView;

public class InputController {
        public static int setQuantity() {
                try {
                        PurchaseAmountValidator validation = new PurchaseAmountValidator(InputView.purchaseInput());
                        return Integer.parseInt(validation.PURCHASE_STRING);
                } catch (IllegalArgumentException e) {
                        System.out.println(Constants.PURCHASE_WRONG_ERROR);
                        return setQuantity();
                }
        }
}
