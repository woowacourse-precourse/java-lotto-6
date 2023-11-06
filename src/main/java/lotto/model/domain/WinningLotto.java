package lotto.model.domain;

import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.MIN_NUMBER;
import static lotto.util.Constants.NUMBERS_SIZE;
import static lotto.util.ExceptionMessage.COMMON_INVALID_RANGE;
import static lotto.util.ExceptionMessage.COMMON_INVALID_TYPE;
import static lotto.util.ExceptionMessage.WINNING_NUMBER_INVALID_DELIMITER;
import static lotto.util.ExceptionMessage.WINNING_NUMBER_INVALID_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.InputValidator;

public class WinningLotto implements InputValidator {

    private List<Integer> numbers;

    @Override
    public boolean getInputUntilValid() {
        return numbers == null;
    }

    public void setWinningNumber(String numbers) {
        List<String> inputDividedByComma = validateDelimiterComma(numbers);
        validateSixElements(inputDividedByComma);
        List<Integer> integerNumbers = validateWinningNumberIsNumeric(inputDividedByComma);
        validateNumberBetweenInRange(integerNumbers);
        this.numbers = integerNumbers;
    }

    public List<String> validateDelimiterComma(String numbers) {
        if (!numbers.matches(".*,.*")) {
            throw new IllegalArgumentException(WINNING_NUMBER_INVALID_DELIMITER.getMessage());
        }
        return List.of(numbers.split(","));
    }

    public void validateSixElements(List<String> numbers) {
        Set<String> set = new HashSet<>(numbers);
        if(set.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_INVALID_SIZE.format(NUMBERS_SIZE));
        }
    }

    public List<Integer> validateWinningNumberIsNumeric(List<String> numbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                int numberToInteger = Integer.parseInt(number);
                integerNumbers.add(numberToInteger);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(COMMON_INVALID_TYPE.getMessage());
            }
        }
        return integerNumbers;
    }

    private void validateNumberBetweenInRange(List<Integer> integerNumbers) {
        for(int number : integerNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(COMMON_INVALID_RANGE.format(MIN_NUMBER, MAX_NUMBER));
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
