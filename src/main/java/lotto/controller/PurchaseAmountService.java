package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.utils.InputUtils;
import lotto.utils.ValidateUtils;

import static lotto.utils.ValidateUtils.*;

public class PurchaseAmountService {

    private PurchaseAmount purchaseAmount;

    public void makePurchaseAmount() {
        try{
            String input = InputUtils.input();
            validateNumberNumeric(input);
            int inputTypeConversion = typeConversion(input);
            purchaseAmount = new PurchaseAmount(inputTypeConversion);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makePurchaseAmount();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getPurchaseAmount();
    }

    private int typeConversion(String input) {
        return Integer.parseInt(input);
    }
}
