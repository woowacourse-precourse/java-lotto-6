package lotto.common;

import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    public static void validateLottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        LottoNumberValidator.validateOverSize(numbers, ConstraintNumber.LOTTO_MAX_SIZE.getValue());
        LottoNumberValidator.validateDuplicated(numbers);
        LottoNumberValidator.validateOutOfRange(
            numbers,
            ConstraintNumber.LOTTO_MIN_NUMBER.getValue(),
            ConstraintNumber.LOTTO_MAX_NUMBER.getValue()
        );
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        LottoNumberValidator.validateOverSize(winningNumbers, ConstraintNumber.LOTTO_MAX_SIZE.getValue());
        LottoNumberValidator.validateOutOfRange(
            winningNumbers,
            ConstraintNumber.LOTTO_MIN_NUMBER.getValue(),
            ConstraintNumber.LOTTO_MAX_NUMBER.getValue()
        );
        LottoNumberValidator.validateDuplicated(winningNumbers);
    }

    public static void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        LottoNumberValidator.validateOutOfRange(
            bonusNumber,
            ConstraintNumber.LOTTO_MIN_NUMBER.getValue(),
            ConstraintNumber.LOTTO_MAX_NUMBER.getValue()
        );
    }

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC);
        }
    }

    public static void validateNumeric(String[] inputStrings) {
        try {
            for (String input : inputStrings) {
                Integer.parseInt(input);
            }
        } catch (Exception exception) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC);
        }
    }

    private static void validateOverSize(List<Integer> numbers, int constraint) {
        if (numbers.size() != constraint) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OVER_SIZE);
        }
    }

    private static void validateOutOfRange(Integer numbers, int startInclusive, int endInclusive) {
        if (numbers < startInclusive || numbers > endInclusive) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void validateOutOfRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (Integer number : numbers) {
            if (number < startInclusive || number > endInclusive) {
                ExceptionHandler.throwIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private static void validateDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED);
        }
    }

}
