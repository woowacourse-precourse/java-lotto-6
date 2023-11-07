package lotto.exception;

import lotto.Constants;

public class UserBuyingException {
    public void validateBuyingException(String buyingPrice) {
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }

    public void validIsNumber(String pay) {
        int buyingPrice = Integer.parseInt(pay);
        if (buyingPrice % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Constants.ERROR + "구매는 1,000원 단위로 가능합니다");
        }
    }
}
