package lotto.model;

import static lotto.util.Validation.validateDivisibleByLottoPrice;
import static lotto.util.Validation.validatePositiveNumber;

import lotto.util.Validation;

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
        Validation.validatePositiveNumber(validNum);
        Validation.validateDivisibleByLottoPrice(validNum);
        return validNum;
    }
}
