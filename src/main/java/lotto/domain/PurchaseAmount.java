package lotto.domain;

import lotto.constant.Errors;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String input){
        int amount = validateNotInteger(input);
        validateUnderThousand(amount);
        validateNotRemainZero(amount);
        this.amount = amount;

    }

    public int getAmout(){
        return amount;
    }

    public void validateUnderThousand(int input){
        if(input < 1000){
            throw new IllegalArgumentException(Errors.PURCHASE_AMOUNT_UNDER_THOUSAND_MESSAGE.getErrorMessage());
        }
    }
    public void validateNotRemainZero(int input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException(Errors.PURCHASE_AMOUNT_REMAIN_NOT_ZERO_MESSAGE.getErrorMessage());
        }
    }
    public int validateNotInteger(String input){
        try{
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(Errors.PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE.getErrorMessage());
        }
    }
}
