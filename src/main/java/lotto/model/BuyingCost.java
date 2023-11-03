package lotto.model;

import lotto.util.Validation;
import lotto.view.InputView;

public class BuyingCost {

    private int buyingCost;
    public BuyingCost() {
        this.buyingCost = 0;
    }

    public Integer getCost(String input) {
        buyingCost = validate(input);
        return buyingCost;
    }
    private int validate(String input) {
        int validNum = Validation.validateInteger(input);
        Validation.validateCost(validNum);
        return validNum;
    }
}
