package lotto.validator;

import lotto.exception.money.MoneyDivisionException;
import lotto.exception.money.MoneyRangeException;

public class PurchasePriceValidator {
    public static final int LOTTO_PRICE = 1000;


    public static void validatePriceRange(int money){
        if (money < LOTTO_PRICE){
            throw new MoneyRangeException();
        }
    }

    public static void validatePriceDivision(int money){
        if (money % LOTTO_PRICE != 0){
            throw new MoneyDivisionException();
        }
    }


}
