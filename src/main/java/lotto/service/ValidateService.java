package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoPrice;

public class ValidateService {
    public int validateNumber(String inputValue){
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    public void validateAll(int purchasePrice){
        validatePrice(purchasePrice);
    }

    private void validatePrice(int purchasePrice){
        if (purchasePrice < LottoPrice.LOTTO_PRICE.getNumber()){
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PRICE_MESSAGE.getMessage());
        }
    }


}
