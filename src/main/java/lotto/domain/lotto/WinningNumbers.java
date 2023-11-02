package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.domain.winningnumber.WinningNumberFormatException;
import lotto.exception.domain.winningnumber.WinningNumberRangeException;
import lotto.exception.domain.winningnumber.WinningNumberSizeException;

public class WinningNumbers {
    private static final Pattern winningNumbersRegex = Pattern.compile("\\d+(,*\\s*\\d*)*");

    private final List<Integer> numbers;

    public static WinningNumbers create(String winningNumber) {
        return new WinningNumbers(winningNumber);
    }

    public Collection<Integer> getNumbers() {
        return Collections.unmodifiableCollection(numbers);
    }

    private WinningNumbers(String winningNumber) {
        validate(winningNumber);
        this.numbers = parseWinningNumbers(winningNumber);
    }

    private void validate(String winningNumber) {
        validateFormat(winningNumber);

        List<Integer> winningNumbers = parseWinningNumbers(winningNumber);
        validateSize(winningNumbers);
        validateRangeOfNumber(winningNumbers);
    }

    private void validateFormat(String winningNumber) {
        Matcher matcher = winningNumbersRegex.matcher(winningNumber);
        boolean isInvalidFormat = !matcher.matches();

        if (isInvalidFormat) {
            throw new WinningNumberFormatException();
        }
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new WinningNumberSizeException();
        }
    }

    private void validateRangeOfNumber(List<Integer> winningNumbers) {
        if (hasInvalidRangeNumber(winningNumbers)) {
            throw new WinningNumberRangeException();
        }
    }

    private static boolean hasInvalidRangeNumber(List<Integer> winningNumbers) {
        return !winningNumbers.stream()
                .allMatch(num -> isValidRange(num));
    }

    private static boolean isValidRange(Integer num) {
        return num >= 1 && num <= 45;
    }

    private List<Integer> parseWinningNumbers(String winningNumber) {
        return Arrays.stream(extractNumbers(winningNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private String[] extractNumbers(String winningNumber) {
        return winningNumber.split("(,+|\\s+)+");
    }
}
