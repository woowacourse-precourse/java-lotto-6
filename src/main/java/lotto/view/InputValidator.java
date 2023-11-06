package lotto.view;

import lotto.global.ResponseStatus;

import static lotto.global.constant.LottoConstant.LOTTO_PRICE;

public class InputValidator {

    public static ResponseStatus purchasePriceCheck(int lottoPurchasePrice){
        if(lottoPurchasePrice < LOTTO_PRICE || lottoPurchasePrice % LOTTO_PRICE != 0){

        }
    }
}
