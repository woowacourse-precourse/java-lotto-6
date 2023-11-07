package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.TreeSet;

import lotto.Constant.ErrorMessage;
import lotto.Constant.LottoNumber;

public class LottoNumberValidator {

    public static void isValid(List<Integer> numbers) {
        hasCorrectLength(numbers);
        areNumbersValidAndUnique(numbers);
    }

    public static List<Integer> convertStringToList(String winningNumbers) {
        List<String> numberStrings = splitNumbers(winningNumbers);
        return convertStringsToIntegers(numberStrings);
    }

    private static List<String> splitNumbers(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","));
    }

    private static List<Integer> convertStringsToIntegers(List<String> numberStrings) {
        return numberStrings.stream()
                .map(String::trim)
                .map(LottoNumberValidator::parseNumber)
                .collect(Collectors.toList());
    }

    private static int parseNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private static void hasCorrectLength(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.COUNT.getNumber()) {
            throw new IllegalArgumentException(
                    ErrorMessage.INCORRECT_NUMBER_COUNT.getMessage(LottoNumber.COUNT.getNumber()));
        }
    }

    private static void areNumbersValidAndUnique(List<Integer> numbers) {
        Set<Integer> winningNumbersSet = new TreeSet<>();
        for (int number : numbers) {
            validateRange(number);
            validateDuplication(number, winningNumbersSet);
        }
    }

    private static void validateRange(int number) {
        if (!isNumberInRange(number)) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_RANGE.getMessage(LottoNumber.MIN_INCLUSIVE.getNumber()
                            , LottoNumber.MAX_INCLUSIVE.getNumber()));
        }
    }

    public static boolean isNumberInRange(int number) {
        return number >= LottoNumber.MIN_INCLUSIVE.getNumber() && number <= LottoNumber.MAX_INCLUSIVE.getNumber();
    }

    private static void validateDuplication(int number, Set<Integer> winningNumbersSet) {
        if (!winningNumbersSet.add(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
