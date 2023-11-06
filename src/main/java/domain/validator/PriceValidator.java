package domain.validator;

import util.ErrorMessage;
import util.ConstantOfLotto;

public class PriceValidator {

    private final int STARNDARD_UNIT = ConstantOfLotto.priceOfLotto;

    public void checkPriceUnit(int price) {
        isPricePositive(price);
        isPriceInStandardUnit(price, STARNDARD_UNIT);
    }
    private void isPriceInStandardUnit(int price, int unit) {
        if(price % unit != 0) {
            System.out.println(ErrorMessage.PRICE_ISNT_IN_STANDARD_UNIT.getErrorMessage());
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