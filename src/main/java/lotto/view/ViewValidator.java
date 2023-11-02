package lotto.view;

import static lotto.constant.ExceptionConstant.BUYING_PRICE_INPUT_EXCEPTION;

public class ViewValidator {

    public boolean validateBuyingPrice(final String buyingPriceText) {
        int buyingPrice = Integer.parseInt(buyingPriceText);

        try {
            if (buyingPrice % 1000 != 0) {
                throw new IllegalArgumentException(BUYING_PRICE_INPUT_EXCEPTION.message);
            }
        } catch (IllegalArgumentException e) {
            String exceptionMessage = e.getMessage();
            System.out.println(exceptionMessage);
            return false;
        }

        return true;
    }
}
