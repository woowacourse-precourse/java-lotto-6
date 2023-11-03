package lotto.model;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {

    public static int validated(String input){
        empty(input);
        return 0; //임시
    }

    public static void empty(String input){
        if(input.length() == 0){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT);
        }
    }

}
