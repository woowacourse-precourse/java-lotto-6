package lotto.lottery;

import lotto.exception.InputValidator;

public class BuyingAmount {

    public BuyingAmount(String buyingAmount) {
        checkBuyingAmount(buyingAmount);
    }

    //구입 금액 예외 체크
    private void checkBuyingAmount(String buyingAmount) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkInputValue(buyingAmount);
        inputValidator.checkBuyingAmount(Integer.parseInt(buyingAmount));
    }
}
