package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoPrice;

public class ValidateService {
    public int validateNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    public void validateAll(int purchasePrice) {
        validatePrice(purchasePrice);
        validateCheckDivisibility(purchasePrice);
    }

    private void validatePrice(int purchasePrice) {
        if (purchasePrice < LottoPrice.LOTTO_PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PRICE_MESSAGE.getMessage());
        }
    }

    private void validateCheckDivisibility(int purchasePrice) {
        if(purchasePrice % LottoPrice.LOTTO_PRICE.getNumber() != 0){
            throw new IllegalArgumentException(ErrorMessage.DIVISIBILITY_CHECK_AMOUNT.getMessage());
        }
    }


}
