package lotto.util.validators;

import static lotto.util.Constants.ERROR;
import static lotto.util.Constants.LOTTO_LENGTH;
import static lotto.util.Constants.ZERO;
import static lotto.util.enums.ErrorMessage.NUMBER_CANNOT_PARSE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.Parser;
import lotto.util.exception.input.DuplicationNumberException;
import lotto.util.exception.input.NumberFormatCustomException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersNegativeException;
import lotto.util.exception.input.NumbersNullException;
import lotto.util.exception.input.WinningNumbersLengthMatchException;


public class WinningNumbersValidator {
    private static final int MAX_NUMBER = 45;

    public static void validateWinningNumbers(String winningNumbers) {
        validateNotNullAndNotEmpty(winningNumbers);

        List<String> parseWinningNumbers = Parser.parseString(winningNumbers);
        List<Integer> parseIntWinningNumbers = parseIntWinningNumbers(parseWinningNumbers);
        
        validateMaxNumber(parseIntWinningNumbers);
        numberDuplicates(parseWinningNumbers);
        lengthCheck(parseWinningNumbers);
        validateNonPositiveWinningNumber(parseWinningNumbers);
    }

//    private static List<Integer> parseIntWinningNumbers(List<String> numbers) {
//        return numbers.stream()
//                .map(str -> {
//                    try {
//                        return Integer.valueOf(str);
//                    } catch (NumberFormatException e) {
//                        throw new NumberFormatException(ERROR + NUMBER_CANNOT_PARSE.getMessage());
//                    }
//                })
//                .collect(Collectors.toList());
//    }

    private static List<Integer> parseIntWinningNumbers(List<String> numbers) {
        return numbers.stream()
                .map(WinningNumbersValidator::parseIntWithCustomException)
                .collect(Collectors.toList());
    }

    private static Integer parseIntWithCustomException(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatCustomException();
        }
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

    private static void validateNotNullAndNotEmpty(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new NumbersNullException();
        }
    }

    private static void validateNonPositiveBonusNumber(String numbers) {
        if (Integer.parseInt(numbers) <= ZERO) {
            throw new NumbersNegativeException();
        }
    }
}
