package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;

public class WinningNumber {

    private static final String COMMA = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    private WinningNumber(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumber createWith(final String number) {
        List<String> numbers = splitWithComma(number);
        validateConvertibleToNumber(numbers);
        validateSixNumbers(numbers);
        validateDuplicates(numbers);
        List<LottoNumber> convertedNumbers = convertToLottoNumbers(numbers);
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

    private static List<LottoNumber> convertToLottoNumbers(final List<String> numbers) {
        return numbers.stream()
                .map(LottoNumber::createWith)
                .toList();
    }

    private static void validateSixNumbers(final List<String> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers.toString());
        }
    }

    private static boolean hasSixNumbers(final List<String> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }

    private static void validateDuplicates(final List<String> numbers) {
        if (hasDuplicates(numbers)) {
            throw new ExistDuplicatedNumberException(numbers.toString());
        }
    }

    private static boolean hasDuplicates(final List<String> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
