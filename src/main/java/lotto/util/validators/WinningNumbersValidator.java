package lotto.util.validators;

import static lotto.util.Constants.LOTTO_LENGTH;
import static lotto.util.Constants.ZERO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Parser;
import lotto.util.exception.input.DuplicationNumberException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersCannotEmpty;
import lotto.util.exception.input.NumbersCannotNegative;
import lotto.util.exception.input.NumbersCannotNull;
import lotto.util.exception.input.WinningNumbersLengthNotMatchException;


public class WinningNumbersValidator {
    private static final int MAX_NUMBER = 45;

    public static void validateWinningNumbers(String winningNumbers) {
        validateNull(winningNumbers);
        validateEmpty(winningNumbers);
        List<String> parseWinningNumbers = Parser.parseString(winningNumbers);
        numberDuplicates(parseWinningNumbers);
        lengthCheck(parseWinningNumbers);
        validateNonPositiveWinningNumber(parseWinningNumbers);
        validateMaxNumber(parseWinningNumbers);
    }

    private static void validateMaxNumber(final List<String> parseWinningNumbers) {
        if (parseWinningNumbers.stream()
                .map(Integer::valueOf)
                .anyMatch(num -> num > MAX_NUMBER)) {
            throw new NumberGreaterException();
        }
    }

    private static void validateNonPositiveWinningNumber(List<String> parseWinningNumbers) {
        parseWinningNumbers.forEach(WinningNumbersValidator::validateNonPositiveBonusNumber);
    }

    private static void lengthCheck(List<String> parseWinningNumbers) {
        if (parseWinningNumbers.size() != LOTTO_LENGTH) {
            throw new WinningNumbersLengthNotMatchException();
        }
    }

    private static void numberDuplicates(List<String> numbers) {
        Set<String> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new DuplicationNumberException();
        }
    }

    private static void validateNull(String winningNumbers) {
        if (winningNumbers == null) {
            throw new NumbersCannotNull();
        }
    }

    private static void validateNonPositiveBonusNumber(String numbers) {
        if (Integer.parseInt(numbers) <= ZERO) {
            throw new NumbersCannotNegative();
        }
    }

    private static void validateEmpty(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new NumbersCannotEmpty();
        }
    }
}
