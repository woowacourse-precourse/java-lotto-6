package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.winningNumber.WinningNumberFormatException;
import lotto.exception.winningNumber.WinningNumberRangeException;
import lotto.exception.winningNumber.WinningNumberSizeException;

public class WinningNumbers {
    private static final Pattern winningNumbersRegex = Pattern.compile("\\d+(,*\\s*\\d*)*");

    private final List<Integer> numbers;

    public WinningNumbers(String winningNumber) {
        validate(winningNumber);
        this.numbers = winningNumbersToList(winningNumber);
    }

    public Collection<Integer> getNumbers() {
        return Collections.unmodifiableCollection(numbers);
    }

    private void validate(String winningNumber) {
        validateFormat(winningNumber);

        List<Integer> winningNumbers = winningNumbersToList(winningNumber);
        validateSize(winningNumbers);
        validateRange(winningNumbers);
    }

    private void validateFormat(String winningNumber) {
        Matcher matcher = winningNumbersRegex.matcher(winningNumber);
        boolean isNotMatch = !matcher.matches();

        if (isNotMatch) {
            throw new WinningNumberFormatException();
        }
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new WinningNumberSizeException();
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        if (hasInvalidRangeNumber(winningNumbers)) {
            throw new WinningNumberRangeException();
        }
    }

    private static boolean hasInvalidRangeNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .allMatch(num -> isValidRange(num));
    }

    private static boolean isValidRange(Integer num) {
        return num >= 1 && num <= 45;
    }

    private List<Integer> winningNumbersToList(String winningNumber) {
        return Arrays.stream(extractNumbers(winningNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private String[] extractNumbers(String winningNumber) {
        return winningNumber.split("\\D+");
    }
}
