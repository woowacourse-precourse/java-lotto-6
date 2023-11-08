package lotto.utils;

import lotto.exception.LottoGameException;

import static lotto.utils.UtilNumber.LOTTO_COST;
import static lotto.exception.ErrorMessage.NOT_INTEGER_ERROR_MESSAGE;

public class Parser {

    public static int parseStringToInt(String stringValue) throws LottoGameException {
        try {
            int intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (Exception e) {
            throw new LottoGameException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public static int parsePaymentToCoin(int payment) {
        return payment / LOTTO_COST.getNumber();
    }
}
