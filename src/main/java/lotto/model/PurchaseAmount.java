package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

public class PurchaseAmount {

    public static int validated(String input){
        empty(input);
        int purchaseAmount = notNumber(input);
        negativeNumber(purchaseAmount);
        under1000(purchaseAmount);
        not1000Unit(purchaseAmount);
        return purchaseAmount;
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

    public static void negativeNumber(int purchaseAmount){
        if(purchaseAmount < 0){
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT);
        }
    }

    public static void under1000(int purchaseAmount){
        if(purchaseAmount < NumberConstant.LOTTO_ONE_PRICE){
            throw new IllegalArgumentException(ErrorMessage.UNDER_1000_PURCHASE_AMOUNT);
        }
    }

    public static void not1000Unit(int purchaseAmount){
        if(purchaseAmount % NumberConstant.LOTTO_ONE_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_1000_UNIT_PURCHASE_AMOUNT);
        }
    }

}
