package lotto.domain;

import lotto.util.Constant;
import lotto.util.ErrorConstant;

import java.util.regex.Pattern;

public class PurchaseManager {
    private Integer purchaseAmount;

    public PurchaseManager(String purchaseAmount){
        isNumber(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        canPurchase();
        hasNoChange();
    }

    private void isNumber(String purchaseAmount) {
        if(!Pattern.matches(Constant.REGEXP_PATTERN_NUMBER, purchaseAmount)){
            throw new IllegalArgumentException(ErrorConstant.NOT_A_NUMBER);
        }
    }

    private void canPurchase() {
        if(purchaseAmount<Constant.LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorConstant.CANNOT_PURCHASE);
        }
    }

    private void hasNoChange() {
        if(purchaseAmount%Constant.LOTTO_PRICE!=0){
            throw new IllegalArgumentException(ErrorConstant.HAS_CHANGE);
        }
    }

    public Integer calcPurchaseNumber() {
        return purchaseAmount/Constant.LOTTO_PRICE;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
