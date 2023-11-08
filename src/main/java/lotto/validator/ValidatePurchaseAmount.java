package lotto.validator;

import lotto.validator.errormessage.ErrorMessage;

public class ValidatePurchaseAmount {

    static final int LOTTO_PRICE=1000;

    public static void validatePurchaseAmount(String buyerInput){
        validateEmpty(buyerInput);
        validateConvertable(buyerInput);
        validateSmallThanThousand(buyerInput);
        validateDividableThousand(buyerInput);

    }

    private static void validateDividableThousand(String buyerInput) {
        if(!canDivide(buyerInput)){
            throw new IllegalArgumentException(ErrorMessage.INDIVIDABLE_THOUSAND.getMessage());
        }
    }

    private static boolean canDivide(String buyerInput){
        return Integer.parseInt(buyerInput) % LOTTO_PRICE ==0;
    }

    private static void validateSmallThanThousand(String buyerInput) {
        int purchaseAmount = Integer.parseInt(buyerInput);
        if(purchaseAmount<LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessage.SMALL_THAN_THOUSAND.getMessage());
        }
    }

    private static void validateConvertable(String buyerInput) {
        if(!buyerInput.matches("-?\\d+")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private static void validateEmpty(String buyerInput) {
        if(buyerInput.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
