package lotto.domain;

import java.util.List;
import lotto.utils.Utils;

public class LottoNumbers {
    private static final String DELIMITER = ",";
    private static final int TOTAL_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public LottoNumbers(String numbers) {
        List<Integer> lottoNumbers = convertStringsToIntegers(convertStringToList(numbers));
        validateLottoNumber(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    public int compareNumbersWithLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int) lottoNumbers.stream().filter(numbers::contains).count();
    }

    private List<Integer> convertStringsToIntegers(List<String> numbers) {
        return numbers.stream()
                .map(Utils::convertStringToInteger)
                .toList();
    }

    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(DELIMITER));
    }

    private void validateLottoNumber(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateRange(numbers);
        validateTotalNumbers(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATED_NUMBER.getValue()
            );
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isValidNumberRange = numbers.stream()
                .allMatch(number -> number >= LottoNumberRange.MIN.getValue() &&
                        number <= LottoNumberRange.MAX.getValue());

        if (!isValidNumberRange) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NUMBER_RANGE.getValue()
            );
        }
    }

    private void validateTotalNumbers(List<Integer> numbers) {
        if (numbers.size() != TOTAL_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    ErrorMessage.TOTAL_NUMBER.getValue()
            );
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        long totalNumber = numbers.stream().distinct().count();
        long sizeOfNumbers = numbers.size();
        return totalNumber == sizeOfNumbers;
    }
}
