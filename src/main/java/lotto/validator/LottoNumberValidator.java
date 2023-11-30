package lotto.validator;

import java.util.HashSet;
import java.util.List;
import lotto.constants.ExceptionMessages;
import lotto.constants.LottoConstants;

public class LottoNumberValidator {
    public static void validateLottoNumbers(List<Integer> numbers) {
        checkNumbersCount(numbers);
        checkAreNumbersInRange(numbers);
        checkAreNumericOnly(numbers);
        checkDuplicateNumExists(numbers);
    }

    private static void checkNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            String errorMessage = ExceptionMessages.LOTTO_NUMBER_COUNT_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void checkAreNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
                String errorMessage = ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR_MESSAGE.getErrorMessage();
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private static void checkAreNumericOnly(List<Integer> numbers) {
        for (Integer number : numbers) {
            try {
                Integer.parseInt(number.toString());
            } catch (Exception e) {
                String errorMessage = ExceptionMessages.LOTTO_NUMBER_TYPE_ERROR_MESSAGE.getErrorMessage();
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private static void checkDuplicateNumExists(List<Integer> numbers) {
        HashSet<Integer> distinctLotto = new HashSet<Integer>(numbers);
        if (distinctLotto.size() != numbers.size()) {
            String errorMessage = ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, String bonusNumber) {
        int number = checkIsNumericValue(bonusNumber);
        checkIsNumberInRangeWithBonusNumber(number);
        checkAreNumericOnlyWithBonusNumber(number);
        checkDuplicateNumExistsWithBonusNumber(numbers, number);
    }

    private static Integer checkIsNumericValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            ExceptionMessages ex = ExceptionMessages.LOTTO_NUMBER_TYPE_ERROR_MESSAGE;
            throw new IllegalArgumentException(ex.getErrorMessage());
        }
    }


    private static void checkIsNumberInRangeWithBonusNumber(Integer bonusNumber) {
        if (bonusNumber < LottoConstants.MIN_LOTTO_NUMBER || bonusNumber > LottoConstants.MAX_LOTTO_NUMBER) {
            String errorMessage = ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void checkAreNumericOnlyWithBonusNumber(Integer bonusNumber) {
        try {
            Integer.parseInt(bonusNumber.toString());
        } catch (Exception e) {
            String errorMessage = ExceptionMessages.LOTTO_NUMBER_TYPE_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void checkDuplicateNumExistsWithBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            String errorMessage = ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }


}
