package view.validator;

import util.ErrorMessage;

public class PriceFormatValidator {

    public int checkPriceFormat(String input) {
        isPriceEmpty(input);
        int price = isPriceContainsOnlyNumber(input);
        return price;
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
}
