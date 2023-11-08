package lotto.utility;

import lotto.utility.enums.ExceptionMessages;
import lotto.utility.enums.Standards;

public class Validation {
    public static void vaildatePurchaseAmount(String purchaseAmount){
        isEmpty(purchaseAmount);
        isNumber(purchaseAmount);
        isDivisibleByThousand(purchaseAmount);
    }

    //사용자 구입 금액 예외처리
    private static void isEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalStateException(ExceptionMessages.IS_EMPTY.getMessage());
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
