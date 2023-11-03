package lotto.validator;

import java.util.List;
import lotto.message.ExceptionMessage;
import lotto.util.LottoUtil;

public class WinnerNumberValidator {

    private static final int LOTTO_SIZE = 6;

    public static void validate(String inputNumbers) {
        validateDividedByComma(inputNumbers);
        validateNaturalNumber(inputNumbers);
        validateNumberLength(inputNumbers);
        validateDuplicatedNumber(inputNumbers);
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

}
