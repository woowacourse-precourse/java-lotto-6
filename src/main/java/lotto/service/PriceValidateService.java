package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.validator.PriceValidator;

public class PriceValidateService {
    public boolean priceValidate(String input) {
        if (numericValidate(input)) {
            int price = Integer.parseInt(input);
            if (multipleValidate(price) && positiveValidate(price)) {
                return true;
            }
        }
        return false;
    }

    private boolean numericValidate(String input) {
        try {
            PriceValidator.isNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_NUMERIC.getMessage());
            return false;
        }
        return true;
    }

    private boolean multipleValidate(int price) {
        try {
            PriceValidator.isMultipleOfLottoPriceUnit(price);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
            return false;
        }
        return true;
    }

    private boolean positiveValidate(int price) {
        try {
            PriceValidator.isPositive(price);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }
        return true;
    }

}
