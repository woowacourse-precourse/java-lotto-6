package domain.validator;

import util.ErrorMessage;

public class PriceUnitValidator {

    private final int STARNDARD_UNIT = 1000;

    public void checkPriceUnit(int price) {
        isPriceInStandardUnit(price, STARNDARD_UNIT);
    }
    private void isPriceInStandardUnit(int price, int unit) {
        if(price % unit != 0) {
            System.out.println(ErrorMessage.PRICE_ISNT_IN_STANDARD_UNIT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}