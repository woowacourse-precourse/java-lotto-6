package lotto.validator;

import lotto.exception.money.MoneyDivisionException;
import lotto.exception.money.MoneyRangeException;

public class MoneyValidator {
    private static final int LOTTO_PRICE = 1000;


    public static void validateMoneyRange(int money){
        if (money < LOTTO_PRICE){
            throw new MoneyRangeException();
        }
    }

    public static void validateMoneyDivision(int money){
        if (money % LOTTO_PRICE != 0){
            throw new MoneyDivisionException();
        }
    }


}
