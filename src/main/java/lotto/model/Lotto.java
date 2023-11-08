package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String winningNumbers) {
        List<Integer> numbers = new ArrayList<>();

        validateConvertBeforeNumbers(winningNumbers);
        String[] parserNumber = winningNumbers.split(",");
        for (String currentNumber : parserNumber) {
            numbers.add(convertStringToInteger(currentNumber));
        }
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNotNullNumber(numbers);
        validateOutOfRangeNumber(numbers);
        validateDuplicatedNumber(numbers);
        validateLengthOfNumber(numbers);
    }

    private void validateConvertBeforeNumbers(String winningNumbers) {
        validateNotNullNumber(winningNumbers);
        validateNonNumericNumbers(winningNumbers);
    }

    private void validateNonNumericNumbers(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9,]*")) {
            throw new IllegalArgumentException(Exception.NON_NUMERIC_LOTTO_NUMBERS_ERROR.getMessage());
        }
    }

    private void validateNotNullNumber(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(Exception.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateNotNullNumber(String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(Exception.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateLengthOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() < numbers.size()) {
            throw new IllegalArgumentException(Exception.DUPLICATED_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private void validateOutOfRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < LottoGameSettingConstValue.MIN_LOTTO_NUMBER.getValue() || num > LottoGameSettingConstValue.MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    protected boolean isInputNumberContainLottoNumbers(Integer inputNumber) {
        return (numbers.contains(inputNumber));
    }

    protected Integer convertStringToInteger(String numbers) {
        Integer convertNumbers;

        try {
            convertNumbers = Integer.parseInt(numbers);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_LOTTO_NUMBER_ERROR.getMessage());
        }
        return convertNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
