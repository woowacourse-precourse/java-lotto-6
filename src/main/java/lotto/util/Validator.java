package lotto.util;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.COMMA_START_END;
import static lotto.exception.ErrorMessage.HAS_REMAINING_NUMBER;
import static lotto.exception.ErrorMessage.HAS_SPACE;
import static lotto.exception.ErrorMessage.NOT_INTEGER;
import static lotto.exception.ErrorMessage.NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.NUMBER_MISS;
import static lotto.exception.ErrorMessage.SIZE_MISS;
import static lotto.util.ConstantMessages.INPUT_PARSER_CHAR;
import static lotto.util.ConstantMessages.SPACE;
import static lotto.util.ConstantNumbers.LOTTO_NUMBER_QUANTITY;
import static lotto.util.ConstantNumbers.MAXIMUM_Lotto_NUMBER;
import static lotto.util.ConstantNumbers.MINIMUM_Lotto_NUMBER;
import static lotto.util.ConstantNumbers.TICKET_PRICE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Validator {
    public static void validateIsInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw LottoException.of(NOT_INTEGER);
        }
    }

    public static void validateListIsInteger(List<String> input) {
        for (String validator : input) {
            validateIsInteger(validator);
        }
    }

    public static void validateHasSpace(String input) {
        if (input.contains(SPACE.getMessage())) {
            throw LottoException.of(HAS_SPACE);
        }
    }

    public static void validateHasRemainingNumber(Integer input) {
        if (input % TICKET_PRICE.getConstant() != 0) {
            throw LottoException.of(HAS_REMAINING_NUMBER);
        }
    }

    public static void validateCommaStartEnd(String input) {
        boolean ifCommaStartEnd = input.startsWith(INPUT_PARSER_CHAR.getMessage())
                || input.endsWith(INPUT_PARSER_CHAR.getMessage());

        if (ifCommaStartEnd) {
            throw LottoException.of(COMMA_START_END);
        }
    }

    public static void validateSizeMiss (List<Integer> input) {
        if (input.size() != LOTTO_NUMBER_QUANTITY.getConstant()) {
            throw LottoException.of(SIZE_MISS);
        }
    }

    public static void validateNumberMinimumOrMaximum(Integer input) {
        if (input < MINIMUM_Lotto_NUMBER.getConstant()
                || input > MAXIMUM_Lotto_NUMBER.getConstant()) {
            throw LottoException.of(NUMBER_MISS);
        }
    }

    public static void validateListNumberMinimumOrMaximum(List<Integer> input) {
        for (Integer eachInput : input) {
            validateNumberMinimumOrMaximum(eachInput);
        }
    }

    public static void validateDuplicateNumber(List<Integer> input) {
        Set<Integer> ifDuplicateNumber = new HashSet<>(input);

        if (ifDuplicateNumber.size() != input.size()) {
            throw LottoException.of(NUMBER_DUPLICATE);
        }
    }

    public static void validateAlreadyHasNumber(List<Integer> lotto, Integer bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw LottoException.of(BONUS_NUMBER_DUPLICATE);
        }
    }
}
