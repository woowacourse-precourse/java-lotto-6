package lotto.validation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.LottoConstants;
import lotto.enums.LottoErrorCodes;

public class WinningNumberValidator {


    public static List<Integer> validateWinningNumbers(String winningNumbers) {
        List<Integer> numbersList = parseToIntList(winningNumbers);
        validateNoDuplicates(numbersList);
        validateSixNumbers(numbersList);
        validateAllNumbersInRange(new LinkedHashSet<>(numbersList));
        return numbersList;
    }


    private static List<Integer> parseToIntList(String winningNumbers) {
        try {
            return Stream.of(winningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(LottoErrorCodes.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(LottoErrorCodes.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private static void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBERS_PER_TICKET.getValue()) {
            throw new IllegalArgumentException(LottoErrorCodes.EXACT_NUMBER_REQUIRED.getMessage());
        }
    }

    private static void validateAllNumbersInRange(Set<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConstants.MINIMUM_NUMBER.getValue() || number > LottoConstants.MAXIMUM_NUMBER.getValue()) {
                throw new IllegalArgumentException(LottoErrorCodes.NUMBER_RANGE_ERROR.getMessage());
            }
        }
    }


}
