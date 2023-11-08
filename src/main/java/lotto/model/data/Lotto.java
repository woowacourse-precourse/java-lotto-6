package lotto.model.data;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import lotto.model.calculator.WinningCalculator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCountOfNumbers(numbers);
        checkRangeOfNumbers(numbers);
        checkDuplicateNumbers(numbers);
    }

    private void checkCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkMinimum(number);
            checkMaximum(number);
        }
    }

    private void checkMinimum(Integer number) {
        if (number < MINIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkMaximum(Integer number) {
        if (number > MAXIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareLottoAndWinningNumbers(List<Integer> winningNumbers) {
        return WinningCalculator.comparingLottoAndWinningNumber(numbers, winningNumbers);
    }

    public int compareLottoAndBonusNumber(Integer bonusNumber) {
        return WinningCalculator.comparingBonusAndWinningNumber(numbers, bonusNumber);
    }
}
