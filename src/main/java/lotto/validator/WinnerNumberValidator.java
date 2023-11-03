package lotto.validator;

import java.util.List;
import lotto.message.ExceptionMessage;
import lotto.util.LottoUtil;

public class WinnerNumberValidator {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public static void validate(String inputNumbers) {
        validateDividedByComma(inputNumbers);
        validateNaturalNumber(inputNumbers);
        validateNumberLength(inputNumbers);
        validateDuplicatedNumber(inputNumbers);
        validateNumberInRange(inputNumbers);
    }

    private static void validateDividedByComma(String inputNumbers) {
        if (!inputNumbers.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVIDED_BY_COMMA.getMessage());
        }
    }

    private static void validateNaturalNumber(String inputNumbers) {
        try {
            LottoUtil.convert(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static void validateNumberLength(String inputNumbers) {
        List<Integer> numbers = LottoUtil.convert(inputNumbers);
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUMBER_LENGTH.getMessage());
        }
    }

    private static void validateDuplicatedNumber(String inputNumbers) {
        List<Integer> numbers = LottoUtil.convert(inputNumbers);
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateNumberInRange(String inputNumbers) {
        List<Integer> numbers = LottoUtil.convert(inputNumbers);
        numbers.forEach(number -> {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_IN_RANGE.getMessage());
            }
        });
    }

}
