package lotto.service.validator;

import lotto.constant.Errors;
import lotto.utils.Parser;

public class PurchaseAmount {

    private Parser parser = new Parser();
    public void validateUnderThousand(String input){
        int purchaseNum = parser.stringToInt(input);
        if(purchaseNum < 1000){
            throw new IllegalArgumentException(Errors.PURCHASE_AMOUNT_UNDER_THOUSAND_MESSAGE.getErrorMessage());
        }
    }

    public void validateNotRemainZero(String input){
        int purchaseNum = parser.stringToInt(input);
        if(purchaseNum % 1000 != 0){
            throw new IllegalArgumentException(Errors.PURCHASE_AMOUNT_REMAIN_NOT_ZERO_MESSAGE.getErrorMessage());
        }
    }

    public void validateNotInteger(String input){
        for(int i = 0 ; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(Errors.PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE.getErrorMessage());
            }
        }
    }
}
