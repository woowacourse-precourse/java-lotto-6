package lotto.utility;

import lotto.utility.enums.ExceptionMessages;
import lotto.utility.enums.Standards;

public class Validation {
    public static void vaildatePurchaseAmount(String purchaseAmount){
        isEmpty(purchaseAmount);
        isNumber(purchaseAmount);
        isDivisibleByThousand(purchaseAmount);
    }

    private static void isEmpty(String purchaseAmount){
        if(purchaseAmount.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.IS_EMPTY.getMessage());
        }
    }

    private static void isNumber(String purchaseAmount){
        try{
            Integer.parseInt(purchaseAmount);
        }catch (NumberFormatException e){
            throw new NumberFormatException(ExceptionMessages.NOT_NUMBER_MESSAGE.getMessage());
        }
    }

    private static void isDivisibleByThousand(String purchaseAmount){
        if(!(Integer.parseInt(purchaseAmount) % Standards.ONE_LOTTO_COST.getNumber() == Standards.ZERO.getNumber())){
            throw new IllegalArgumentException(ExceptionMessages.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
