package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;

public class WinningNumber {

    private static final String COMMA = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    private WinningNumber(final List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    public static WinningNumber createWith(final String number) {
        List<String> numbers = splitWithComma(number);
        validateConvertibleToNumber(numbers);
        List<Integer> convertedNumbers = convertToNumbers(numbers);
        validateSixNumbers(convertedNumbers);
        validateDuplicates(convertedNumbers);
        return new WinningNumber(convertedNumbers);
    }

    private static List<String> splitWithComma(final String numbers) {
        return Arrays.stream(numbers.split(COMMA))
                .toList();
    }

    private static void validateConvertibleToNumber(final List<String> numbers) {
        numbers.stream()
                .filter(number -> !isNumeric(number))
                .findFirst()
                .ifPresent(number -> {
                    throw new CanNotConvertToNumberException(number);
                });
    }

    private static boolean isNumeric(final String number) {
        return number.chars()
                .allMatch(Character::isDigit);
    }

    private static List<Integer> convertToNumbers(final List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateSixNumbers(final List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers);
        }
    }

    private static boolean hasSixNumbers(final List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new ExistDuplicatedNumberException(numbers);
        }
    }

    private static boolean hasDuplicates(final List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
