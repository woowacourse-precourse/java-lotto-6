package lotto.controller;

import lotto.validator.PurchaseAmountValidator;
import lotto.view.View;

public class LottoController {
    View view = new View();
    PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public void run() {
        view.printPurchaseAmountInputMessage();
        while (true) {
            try {
                String purchaseAmount = view.inputValue();
                purchaseAmountValidator.validate(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
