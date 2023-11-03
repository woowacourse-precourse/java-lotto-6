package lotto.model;

import lotto.util.Validation;

public class BuyingCost {

    private final Validation validation;
    private int buyingCost;
    public BuyingCost(Validation validation) {
        this.validation = validation;
        this.buyingCost = 0;
    }

    public Integer getCost(String input) {
        this.buyingCost = validation.validateNumeric(input);
        validation.validateCost(buyingCost);
        return buyingCost;
    }
}
