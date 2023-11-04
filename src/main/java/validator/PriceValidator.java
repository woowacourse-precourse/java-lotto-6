package validator;

import util.ErrorMessage;

public class PriceValidator {

    public void checkPriceValidate(String input) {
        isPriceEmpty(input);
        int price = isPriceContainsOnlyNumber(input);
        isPricePositive(price);
        isMultipleOfThousandWon(price);
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

    private void isMultipleOfThousandWon(int price) {
        if(price % 1000 != 0) {
            System.out.println(ErrorMessage.PRICE_ISNT_MULTIPLE_OF_THOUSAND_WON.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
