package lotto.domain;


import static lotto.validate.InputValidation.THOUSAND;

import lotto.validate.InputValidation;

public class Purchase {
    private int purchase;

    private int quantity;
    public Purchase(String purchaseAmount) {
        this.quantity = calculateQuantity(purchaseAmount);
        this.purchase = Integer.parseInt(purchaseAmount);
    }

    public int getQuantity() {
        return quantity;
    }
    public int getPurchase() {
        return purchase;
    }

    private int calculateQuantity(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / THOUSAND;
    }

    // 구입금액 validation
    public void validatePurchaseAmount(String amount) {
        InputValidation inputValidation = new InputValidation();

        inputValidation.isNumber(amount);
        inputValidation.isDividedOneThousand(Integer.parseInt(amount));
        inputValidation.isNullOrBlank(amount);
    }

}
