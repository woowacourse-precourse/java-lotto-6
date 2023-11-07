package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.domain.winningnumber.WinningNumberFormatException;
import lotto.utils.LottoValidator;

public class WinningNumbers {
    private static final Pattern winningNumbersRegex = Pattern.compile("\\d+(,*\\s*\\d*)*");

    private final List<Integer> numbers;

    private WinningNumbers(String winningNumber) {
        validate(winningNumber);
        this.numbers = parseWinningNumbers(winningNumber);
    }

    public static WinningNumbers create(String winningNumber) {
        return new WinningNumbers(winningNumber);
    }

    private void validate(String winningNumber) {
        validateFormat(winningNumber);

        List<Integer> winningNumbers = parseWinningNumbers(winningNumber);
        LottoValidator.validateSize(winningNumbers);
        LottoValidator.validateRangeOfNumber(winningNumbers);
        LottoValidator.validateDuplicateNumber(winningNumbers);
    }

    private void validateFormat(String winningNumber) {
        Matcher matcher = winningNumbersRegex.matcher(winningNumber);
        boolean isInvalidFormat = !matcher.matches();

        if (isInvalidFormat) {
            throw new WinningNumberFormatException();
        }
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

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
