package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.util.StringUtil;

public class WinningNumbersValidator {
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static final String INPUT_PATTERN = "^[0-9,]+$";
    private static final int EXPECTED_COMMA_COUNT = 5;

    public static List<Integer> validateWinningNumbers(String input) {
        validateInputFormat(input);
        validateCommaCount(input);

        List<Integer> winningNumbers = StringUtil.splitAndParse(input, ",");
        validateNumberRange(winningNumbers);
        validateDuplicateNumbers(winningNumbers);

        return winningNumbers;
    }

    public static void validateCommaCount(String input) {
        if (countCommas(input) != EXPECTED_COMMA_COUNT) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }

    public static void validateInputFormat(String input) {
        if (!input.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표(,)만 입력해 주세요.");
        }
    }

    private static int countCommas(String input) {
        Matcher matcher = COMMA_PATTERN.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static void validateNumberRange(List<Integer> winningNumbers) {
        for (Integer num : winningNumbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.");
            }
        }
    }

    private static void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력해 주세요.");
        }
    }
}
