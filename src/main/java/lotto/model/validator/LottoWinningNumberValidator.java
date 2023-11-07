
package lotto.model.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumberValidator {
    public static List<Integer> validateWinningNumbers(String input) {
        ensureNotEmpty(input);
        String[] numberStrings = splitInput(input);
        ensureCorrectCount(numberStrings);
        List<Integer> numbers = parseNumbers(numberStrings);
        ensureValidRange(numbers);
        ensureNoDuplicates(numbers);

        return numbers;
    }

    private static void ensureNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해야 합니다.");
        }
    }

    private static String[] splitInput(String input) {
        return input.split(",");
    }

    private static void ensureCorrectCount(String[] numberStrings) {
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static List<Integer> parseNumbers(String[] numberStrings) {
        try {
            return Arrays.stream(numberStrings)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private static void ensureValidRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
        }
    }

    private static void ensureNoDuplicates(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복될 수 없습니다.");
        }
    }
}
