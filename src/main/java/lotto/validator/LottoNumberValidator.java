package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.TreeSet;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;

public class LottoNumberValidator {

    private LottoNumberValidator() {}

    public static void isValid(List<Integer> numbers) {
        hasCorrectLength(numbers);
        areNumbersValidAndUnique(numbers);
    }

    public static List<Integer> convertStringToList(String winningNumbers) {
        List<String> splitNumberStrings = splitNumbers(winningNumbers);
        return convertStringsToIntegers(splitNumberStrings);
    }

    private static List<String> splitNumbers(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","));
    }

    private static List<Integer> convertStringsToIntegers(List<String> splitNumberStrings) {
        return splitNumberStrings.stream()
                .map(String::trim)
                .map(LottoNumberValidator::parseNumber)
                .collect(Collectors.toList());
    }

    private static int parseNumber(String splitNumberString) {
        try {
            return Integer.parseInt(splitNumberString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.INVALID_FORMAT.getMessage());
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
        if (isNumberOutOfRange(number)) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_RANGE.getMessage(LottoNumber.MIN_INCLUSIVE.getNumber()
                            , LottoNumber.MAX_INCLUSIVE.getNumber()));
        }
    }

    public static boolean isNumberOutOfRange(int number) {
        return number < LottoNumber.MIN_INCLUSIVE.getNumber() || number > LottoNumber.MAX_INCLUSIVE.getNumber();
    }

    private static void validateDuplication(int number, Set<Integer> winningNumbersSet) {
        if (!winningNumbersSet.add(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
