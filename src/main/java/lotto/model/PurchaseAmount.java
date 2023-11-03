package lotto.model;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {

    public static int validated(String input){
        empty(input);
        int purchaseAmount = notNumber(input);
        return 0; //임시
    }

    public static void empty(String input){
        if(input.length() == 0){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT);
        }
    }

    public static int notNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT);
        }
    }

}
