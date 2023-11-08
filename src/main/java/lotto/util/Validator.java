package lotto.util;

import java.util.List;
import lotto.constant.Constant;

public class Validator {

    private Validator() {
    }

    public static void validateLottoNumbers(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }


    public static void validateBonusNumber(final int bonusNumber, final List<Integer> winningNumbers) {
        validateRangeBonusNumber(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber, winningNumbers);
    }

    public static void validateMoney(final int money) {
        validateNumberFormat(money);
        validateMoneyUnit(money);
    }

    public static void validateInputRange(final String input) {
        if (input.length() > 9) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_OUT_OF_RANGE);
        }
    }

    private static void validateMoneyUnit(final int money) {
        if (money % Constant.MONEY_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_WRONG_UNIT);
        }
    }

    private static void validateNumberFormat(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_FORMAT);
        }
    }


    private static void validateRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < Constant.NUMBER_MIN || num > Constant.NUMBER_MAX)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_RANGE);
        }
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_WRONG_SIZE);
        }
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_DUPLICATE);
        }
    }

    private static void validateDuplicateBonusNumber(final int number, final List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_AND_WINNING_DUPLICATE);
        }
    }

    private static void validateRangeBonusNumber(final int number) {
        if (number < Constant.NUMBER_MIN || number > Constant.NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_RANGE);
        }
    }


}
