package lotto.model.data;

import static lotto.model.calculator.WinningCalculator.comparingBonusAndWinningNumber;
import static lotto.model.calculator.WinningCalculator.comparingLottoAndWinningNumber;
import static lotto.model.validator.LottoNumberValidator.checkCountOfNumbers;
import static lotto.model.validator.LottoNumberValidator.checkDuplicateNumbers;
import static lotto.model.validator.LottoNumberValidator.checkRangeOfNumbers;

import java.util.List;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareLottoAndWinningNumbers(List<Integer> winningNumbers) {
        return comparingLottoAndWinningNumber(numbers, winningNumbers);
    }

    public int compareLottoAndBonusNumber(Integer bonusNumber) {
        return comparingBonusAndWinningNumber(numbers, bonusNumber);
    }
}
