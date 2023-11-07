package lotto.validate;

import lotto.config.ErrorMessage;

public class Validator {
    public String validatePurchaseCost(String purchaseCost){
        if(!purchaseCost.matches("\\d+")){
            throw new NumberFormatException(ErrorMessage.ERROR_PURCHASE_COST_POSITIVE_INTEGER.getErrorMessage());
        }
        int tmpCost = Integer.parseInt(purchaseCost);
        if(tmpCost % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_COST_MULTIPLE_1000.getErrorMessage());
        }
        return purchaseCost;
    }

}
