package lotto.domain;

import static lotto.constant.message.ErrorMessage.NON_INTEGER_BONUS_NUMBER;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String number) {
        this.bonusNumber = validateBonusNumber(number);
    }

    private int validateBonusNumber(String number) {

    }

    private void checkValidInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_BONUS_NUMBER.getMessage());
        }
    }
}
