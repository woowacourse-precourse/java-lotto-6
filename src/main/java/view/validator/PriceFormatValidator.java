package view.validator;

import util.ErrorMessage;

public class PriceFormatValidator {

    public void checkPriceFormat(String input) {
        isPriceEmpty(input);
        isPriceContainsOnlyNumber(input);
    }

    private void isPriceEmpty(String input) {
        if(input.isEmpty()) {
            System.out.println(ErrorMessage.PRICE_DOESNT_ENTER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void isPriceContainsOnlyNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.out.println(ErrorMessage.PRICE_CONTAIN_NON_NUMERIC_CHARACTER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
