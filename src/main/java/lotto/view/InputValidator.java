package lotto.view;

import lotto.domain.Lotto;

import static lotto.utils.ErrorMessages.*;

public class InputValidator {

    public static int calculateTicketCount(int payment) {
        if (payment % 1000 != 0) throw new IllegalArgumentException(PAYMENT_OVER_1000_UNIT);
        return payment / 1000;
    }

    public static int parseNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_FORMAT);
        }
    }
    public static void checkDuplicateBonusNumber(int bonusNumber, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) throw new IllegalArgumentException(CHECK_INPUT_BONUS_NUMBER);
    }
}
