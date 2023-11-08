package lotto;

import static lotto.util.Constant.Exception_MESSAGE.*;
import static lotto.util.Constant.InputClass.TICKET_AMOUNT;

public class Exception {
    public static void isValidNotThousandAndNegativeException(int count) {
        if (count % TICKET_AMOUNT != 0 || count < 0) throw new IllegalArgumentException(NOT_THOUSAND_AND_NEGATIVE_EXCEPTION);
    }

    public static void isValidDuplicateNumberException(boolean isDuplicated) {
        if (!isDuplicated) throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
    }

    public static void isValidSixNumberException(int number) {
        if (number != 6) throw new IllegalArgumentException(SIX_NUMBER_EXCEPTION);
    }

    public static int isValidNumberFormatException(String number) {
        int count;
        try {
            count = Integer.parseInt(number);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    public static void isValidLottoNumberRangeException(Integer number){
        if (number < 0 || number > 46) throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION);
    }
}
