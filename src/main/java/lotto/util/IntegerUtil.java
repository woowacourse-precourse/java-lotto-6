package lotto.util;

import lotto.model.LottoNumbers;
import lotto.view.ErrorMessage;

public class IntegerUtil {

    public static void checkRange(int number) {
        if (number < LottoNumbers.START_LOTTO_NUMBER || number > LottoNumbers.END_LOTT0_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }
}
