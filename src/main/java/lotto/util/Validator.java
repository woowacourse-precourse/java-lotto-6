package lotto.util;

import static lotto.exception.ErrorMessage.HAS_REMAINING_NUMBER;
import static lotto.exception.ErrorMessage.HAS_SPACE;
import static lotto.exception.ErrorMessage.NOT_INTEGER;
import static lotto.util.ConstantNumbers.RESET_INTEGER_NUMBER;
import static lotto.util.ConstantNumbers.TICKET_PRICE;

import lotto.exception.LottoException;

public class Validator {
    public static void validateIsInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw LottoException.of(NOT_INTEGER);
        }
    }

    public static void validateHasSpace(String input) {
        if (input.contains(" ")) {
            throw LottoException.of(HAS_SPACE);
        }
    }

    public static void validateHasRemainingNumber(Integer input) {
        if (input % TICKET_PRICE.getConstant() != RESET_INTEGER_NUMBER.getConstant()) {
            throw LottoException.of(HAS_REMAINING_NUMBER);
        }
    }
}
