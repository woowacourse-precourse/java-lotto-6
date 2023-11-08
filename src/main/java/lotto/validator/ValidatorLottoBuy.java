package lotto.validator;

import java.math.BigDecimal;

import lotto.error.LottoErrorMessage;
import lotto.exception.LottoNumberException;

public class ValidatorLottoBuy {
    public static void validateString(String buyingPrice) {
        isNumericValue(buyingPrice);
    }

    public static void validateNumber(BigDecimal buyingPrice, BigDecimal price) {
        isEnoughMoney(buyingPrice, price);
        isDivideNoRemain(buyingPrice, price);
    }

    private static void isDivideNoRemain(BigDecimal buyingPrice, BigDecimal price) {
        BigDecimal remainder = buyingPrice.remainder(price);
        if (BigDecimal.ZERO.compareTo(remainder) != 0) {
            throw LottoNumberException.of(LottoErrorMessage.BUYING_PRICE_MUST_PRICE_UNIT);
        }
    }

    private static void isEnoughMoney(BigDecimal buyingPrice, BigDecimal price) {
        int compareResult = buyingPrice.compareTo(price);
        if (compareResult < 0) {
            throw LottoNumberException.of(LottoErrorMessage.NOT_ENOUGH_MONEY);
        }
    }

    private static void isNumericValue(String buyingPrice) {
        try {
            new BigDecimal(buyingPrice);
        } catch (NumberFormatException e) {
            throw LottoNumberException.of(LottoErrorMessage.WRONG_LOTTO_PRICE);
        }
    }

}
