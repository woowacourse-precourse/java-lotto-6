package view.validator;

import util.ErrorMessage;

public class PriceFormatValidator {

    public void checkPriceFormat(String input) {
        isPriceEmpty(input);
        int price = isPriceContainsOnlyNumber(input);
        isPricePositive(price);
    }

    private void isPriceEmpty(String input) {
        if(input.isEmpty()) {
            System.out.println(ErrorMessage.PRICE_DOESNT_ENTER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private int isPriceContainsOnlyNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.out.println(ErrorMessage.PRICE_CONTAIN_NON_NUMERIC_CHARACTER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void isPricePositive(int price) {
        if(price < 0) {
            System.out.println(ErrorMessage.PRICE_IS_NEGATIVE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
