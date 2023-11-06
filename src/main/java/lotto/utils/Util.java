package lotto.utils;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.message.ErrorMessage;

public class Util {

    public static BigDecimal getHowManyTimes(BigDecimal purchaseAmount, BigDecimal lottoPrice) {
        validateMultiplesOf(purchaseAmount, lottoPrice);
        return purchaseAmount.divide(lottoPrice, BigDecimal.ROUND_DOWN);
    }

    public static void validateMultiplesOf(BigDecimal num, BigDecimal factor) {
        if (num.remainder(factor).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
        }
    }

    public static void validateNumber(String input) {
        try {
            new BigDecimal(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
        }
    }
}
