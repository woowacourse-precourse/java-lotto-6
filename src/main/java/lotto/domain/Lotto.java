package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascendingSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1)
                throw new IllegalArgumentException();
        }
    }

    protected List<Integer> ascendingSort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareWinningLottoNumbers(List<Integer> winningNumbers) {
        int matchNumber = 0;

        for (Integer playerNumber : numbers) {
            if (winningNumbers.contains(playerNumber))
                matchNumber++;
        }
        return matchNumber;
    }

    public boolean isCorrectBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
