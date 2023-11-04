package lotto.domain;

import static lotto.constant.message.ErrorMessage.NON_INTEGER_BONUS_NUMBER;

public class BonusNumberValidator {
    private void checkValidInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_BONUS_NUMBER.getMessage());
        }

    }
}
