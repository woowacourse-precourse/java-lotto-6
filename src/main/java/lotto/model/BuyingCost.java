package lotto.model;

import lotto.util.Validation;
import lotto.view.InputView;

public class BuyingCost {

    private int buyingCost;
    public BuyingCost() {
        this.buyingCost = 0;
    }

    public Integer getCost(String input) {
        this.buyingCost = Validation.validateInteger(input);
        Validation.validateCost(buyingCost);
        return buyingCost;
    }
    public int getValidCost(InputView inputView) {
        int validCost = 0;
        while (true) {
            try {
                validCost = getCost(inputView.inputPurchaseCost());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return validCost;
    }
}
