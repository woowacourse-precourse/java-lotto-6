package lotto.validation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberValidator {
    private static final int MINIMUM_WINNING_NUMBER = 1;
    private static final int MAXIMUM_WINNING_NUMBER = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;

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
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.", exception);
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 정확히 6개의 숫자를 입력해야 합니다.");
        }
    }

    private static void validateAllNumbersInRange(Set<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_WINNING_NUMBER || number > MAXIMUM_WINNING_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 숫자는 " + MINIMUM_WINNING_NUMBER + "에서 " + MAXIMUM_WINNING_NUMBER + " 사이어야 합니다: " + number);
            }
        }
    }


}
