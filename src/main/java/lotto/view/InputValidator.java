package lotto.view;

import lotto.global.ResponseStatus;
import lotto.global.error.ErrorMessage;

import static lotto.global.constant.LottoConstant.LOTTO_PRICE;

public class InputValidator {

    public static ResponseStatus purchasePriceCheck(int lottoPurchasePrice){
        if(lottoPurchasePrice < LOTTO_PRICE || lottoPurchasePrice % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PURCHASE_PRICE.getMessage());
        }
        return ResponseStatus.OK;
    }
}
