package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(String input){
        int tempPurchaseAmount = notNumber(input);
        negativeNumber(tempPurchaseAmount);
        under1000(tempPurchaseAmount);
        not1000Unit(tempPurchaseAmount);
        purchaseAmount = tempPurchaseAmount;
    }

    private int notNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT);
        }
    }

    private void negativeNumber(int purchaseAmount){
        if(purchaseAmount < 0){
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT);
        }
    }

    private void under1000(int purchaseAmount){
        if(purchaseAmount < NumberConstant.LOTTO_ONE_PRICE){
            throw new IllegalArgumentException(ErrorMessage.UNDER_1000_PURCHASE_AMOUNT);
        }
    }

    private void not1000Unit(int purchaseAmount){
        if(purchaseAmount % NumberConstant.LOTTO_ONE_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_1000_UNIT_PURCHASE_AMOUNT);
        }
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }

}
