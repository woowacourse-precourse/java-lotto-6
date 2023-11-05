package lotto.util.validators;

import static lotto.util.Constants.LOTTO_LENGTH;
import static lotto.util.Constants.ZERO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.Parser;
import lotto.util.exception.input.DuplicationNumberException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersEmptyException;
import lotto.util.exception.input.NumbersNegativeException;
import lotto.util.exception.input.NumbersNullException;
import lotto.util.exception.input.WinningNumbersLengthMatchException;


public class WinningNumbersValidator {
    private static final int MAX_NUMBER = 45;

    public static void validateWinningNumbers(String winningNumbers) {
        validateNull(winningNumbers);
        validateEmpty(winningNumbers);
        List<String> parseWinningNumbers = Parser.parseString(winningNumbers);
        validateMaxNumber(parseIntWinningNumbers(parseWinningNumbers)); // 먼저 최대 숫자를 검증
        numberDuplicates(parseWinningNumbers);
        lengthCheck(parseWinningNumbers);
        validateNonPositiveWinningNumber(parseWinningNumbers);
    }

    private static List<Integer> parseIntWinningNumbers(List<String> numbers) {
        return numbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void validateMaxNumber(final List<Integer> parsedWinningNumbers) {
        if (parsedWinningNumbers.stream().anyMatch(num -> num > MAX_NUMBER)) {
            throw new NumberGreaterException();
        }
    }

    private static void validateNonPositiveWinningNumber(List<String> parseWinningNumbers) {
        parseWinningNumbers.forEach(WinningNumbersValidator::validateNonPositiveBonusNumber);
    }

    private static void lengthCheck(List<String> parseWinningNumbers) {
        if (parseWinningNumbers.size() != LOTTO_LENGTH) {
            throw new WinningNumbersLengthMatchException();
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
            throw new NumbersNullException();
        }
    }

    private static void validateNonPositiveBonusNumber(String numbers) {
        if (Integer.parseInt(numbers) <= ZERO) {
            throw new NumbersNegativeException();
        }
    }

    private static void validateEmpty(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new NumbersEmptyException();
        }
    }
}
