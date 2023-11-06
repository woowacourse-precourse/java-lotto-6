package lotto.utils;

import static lotto.utils.ExceptionMessage.NON_DIVISIBLE_BY_1000;
import static lotto.utils.ExceptionMessage.NOT_NUMBER;

public class PurchaseAmountException {

    public void notNumeric(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(NOT_NUMBER));
        }
    }

    public void notDivisible(String input) {
        int numberInput = Integer.parseInt(input);
        if(numberInput % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(NON_DIVISIBLE_BY_1000));
        }
    }
}
