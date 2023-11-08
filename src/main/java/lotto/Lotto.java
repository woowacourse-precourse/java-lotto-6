package lotto;

import enums.LottoError;
import enums.LottoScore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoError.NUMBER_COUNT_ERROR.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LottoError.NUMBER_RANGE_ERROR.getMessage());
            }

            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(LottoError.NUMBER_DUPLICATE_ERROR.getMessage());
            }
            uniqueNumbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoScore calculate(List<Integer> winningNumbers, int bonusNumber) {
        int correctCount = countCorrectNumbers(winningNumbers);
        boolean correctBonus = isCorrectBonusNumber(bonusNumber);
        if(correctCount == 6)
            return LottoScore.FIRST;
        if(correctCount == 5 && correctBonus)
            return LottoScore.SECOND;
        if(correctCount == 5)
            return LottoScore.THIRD;
        if(correctCount == 4)
            return LottoScore.FOURTH;
        if(correctCount == 3)
            return LottoScore.FIFTH;
        return LottoScore.NO;
    }

    private int countCorrectNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : winningNumbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isCorrectBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
