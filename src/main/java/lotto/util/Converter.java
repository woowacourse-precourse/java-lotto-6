package lotto.util;

import lotto.validation.LottoException;

public class Converter {

    public static int convertPurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.LETTER_ERROR_MESSAGE.getMessage());
        }
    }


}
