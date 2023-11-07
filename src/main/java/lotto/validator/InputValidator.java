package lotto.validator;

import static lotto.condition.LottoCondition.LOTTO_COUNT;
import static lotto.condition.LottoCondition.LOTTO_PRICE;
import static lotto.condition.LottoCondition.MAXIMUM_LOTTO_NUMBER;
import static lotto.condition.LottoCondition.MINIMUM_LOTTO_NUMBER;
import static lotto.condition.Symbols.DELIMITER;
import static lotto.exception.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.EMPTY;
import static lotto.exception.ErrorMessage.ENDS_WITH_DELIMITER;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT_INPUT;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_INPUT;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT;

import java.util.List;
import lotto.exception.LottoException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw LottoException.of(EMPTY);
        }
    }

    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(DELIMITER.getSymbol())) {
            throw LottoException.of(ENDS_WITH_DELIMITER);
        }
    }

    public static void validatePurchaseAmount(final int input) {
        if (input % LOTTO_PRICE.getValue() != 0) {
            throw LottoException.of(INVALID_PURCHASE_AMOUNT);
        }
    }

    public static void validateDuplicateNumber(final List<Integer> input) {
        if (input.stream().distinct().count() != input.size()) {
            throw LottoException.of(DUPLICATE_LOTTO_NUMBER);
        }
    }

    public static void validateDuplicateBonusNumber(final List<Integer> input, final int bonusNumber) {
        if (input.contains(bonusNumber)) {
            throw LottoException.of(DUPLICATE_LOTTO_NUMBER);
        }
    }


    public static void validateLottoNumberCount(final List<Integer> input) {
        if (input.size() != LOTTO_COUNT.getValue()) {
            throw LottoException.of(INVALID_LOTTO_NUMBER_COUNT_INPUT);
        }
    }

    public static void validateLottoNumberRange(final int input) {
        if (isNumberOutOfRange(input)) {
            throw LottoException.of(INVALID_LOTTO_NUMBER_INPUT);
        }
    }

    private static boolean isNumberOutOfRange(final int input) {
        return input > MAXIMUM_LOTTO_NUMBER.getValue() || input < MINIMUM_LOTTO_NUMBER.getValue();
    }
}
