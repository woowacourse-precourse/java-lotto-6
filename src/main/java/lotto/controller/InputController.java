package lotto.controller;

import lotto.Constants;

import lotto.model.WinningNumValidator;
import lotto.model.BonusNumValidator;
import lotto.model.PurchaseNumValidator;
import lotto.view.InputView;

public class InputController {
        public static int setPurchaseNum() {
                try {
                        PurchaseNumValidator validation = new PurchaseNumValidator(InputView.purchaseInput());
                        return Integer.parseInt(validation.PURCHASE_STRING);
                } catch (IllegalArgumentException e) {
                        System.out.println(Constants.PURCHASE_WRONG_ERROR);
                        return setPurchaseNum();
                }
        }

}
