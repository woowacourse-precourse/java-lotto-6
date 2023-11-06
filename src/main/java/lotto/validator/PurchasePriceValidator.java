package lotto.validator;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

import lotto.exception.money.MoneyDivisionException;
import lotto.exception.money.MoneyRangeException;

public class PurchasePriceValidator {


    public static void validatePriceRange(int money){
        if (money < LOTTO_PRICE.getValue()){
            throw new MoneyRangeException();
        }
    }

    public static void validatePriceDivision(int money){
        if (money % LOTTO_PRICE.getValue() != 0){
            throw new MoneyDivisionException();
        }
    }


}
