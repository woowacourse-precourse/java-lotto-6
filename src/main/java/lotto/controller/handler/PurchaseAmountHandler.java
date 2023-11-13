package lotto.controller.handler;

import lotto.controller.converter.PurchaseAmountConverter;
import lotto.controller.validator.PurchaseAmountValidator;

public class PurchaseAmountHandler extends InputHandler<Integer> {

    public PurchaseAmountHandler(String purchaseNumber) {
        this.input = purchaseNumber;
        this.converter = new PurchaseAmountConverter();
        this.validator = new PurchaseAmountValidator();
    }
}
