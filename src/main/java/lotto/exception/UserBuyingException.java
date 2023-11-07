package lotto.exception;

import lotto.Constants;

public class UserBuyingException {
    public void validateBuyingException(String buyingPrice) {
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }

    public void validPrice(String pay) {
        int buyingPrice = Integer.parseInt(pay);
        if (buyingPrice % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Constants.ERROR + "구매는 1,000원 단위로 가능합니다");
        }
    }
    public void validIsNumber(String nonNumeric) {
        for (int i = 0; i < nonNumeric.length(); i++) {
            if (!Character.isDigit(nonNumeric.charAt(i))) {
                throw new NumberFormatException(Constants.ERROR + "숫자를 입력하세요");
            }
        }
    }
}
