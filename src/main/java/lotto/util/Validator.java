package lotto.util;

import lotto.LottoManager;
import lotto.message.ErrorMessage;

import java.util.List;

public class Validator {
    public static void validateDigit(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public static void validateAmountInThousands(int amount) throws IllegalArgumentException {
        int THOUSAND = 1000;
        if (amount % THOUSAND != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT);
        }
    }

    public static void validateNumberOfLottoNumbers(List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.size() != LottoManager.NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_LOTTO_NUMBER_COUNT);
        }
    }
}
