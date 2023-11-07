package lotto;

import static lotto.LottoConstants.LOTTO_NUMBERS;

import exception.LottoException;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException(LottoException.DUPLICATE_LOTTO_NUMBERS);
        }
    }

    public void isBonusNumberDuplicate(int bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.DUPLICATE_LOTTO_NUMBERS);
        }
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public int getMatchingCountOfWinningNumbers(Lotto winningNumbers) {
        int countOfMatch = 0;
        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                countOfMatch++;
            }
        }
        return countOfMatch;
    }

    private boolean contains(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
