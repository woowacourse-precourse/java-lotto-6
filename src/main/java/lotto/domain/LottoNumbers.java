package lotto.domain;

import java.util.List;
import lotto.input.InputErrorMessage;
import lotto.utils.Utils;

public class LottoNumbers {
    private final static String DELIMITER = ",";
    private final static String PATTERN_ONLY_INTEGERS = "\\d+";
    private final List<Integer> numbers;

    public LottoNumbers(String numbers) {
        List<Integer> lottoNumbers = convertStringsToIntegers(convertStringToList(numbers));
        validateLottoNumber(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private List<Integer> convertStringsToIntegers(List<String> numbers) {
        validateHasOnlyIntegers(numbers);
        return numbers.stream()
                .map(Utils::convertStringToInteger)
                .toList();
    }

    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(DELIMITER));
    }

    private void validateLottoNumber(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateNumbersRange(numbers);
    }

    private void validateHasOnlyIntegers(List<String> numbers) {
        boolean hasOnlyIntegers = numbers.stream()
                .allMatch(string -> string.matches(PATTERN_ONLY_INTEGERS));

        if (!hasOnlyIntegers) {
            throw new IllegalArgumentException(
                    InputErrorMessage.INVALID_LOTTO_NUMBERS.getValue()
            );
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(
                    InputErrorMessage.DUPLICATED_NUMBER.getValue()
            );
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        boolean isValidNumberRange = numbers.stream()
                .allMatch(number -> number >= LottoNumberRange.MIN.getValue() &&
                        number <= LottoNumberRange.MAX.getValue());

        if (!isValidNumberRange) {
            throw new IllegalArgumentException(
                    InputErrorMessage.INVALID_NUMBER_RANGE.getValue()
            );
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        long totalNumber = numbers.stream().distinct().count();
        long sizeOfNumbers = numbers.size();
        return totalNumber == sizeOfNumbers;
    }
}
