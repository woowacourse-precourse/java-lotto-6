package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Winning;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Winning checkWinning(Lotto winningLotto, int bonusNumber) {
        if (this.numbers.equals(winningLotto.numbers)) {
            return Winning.FIRST;
        }
        if (winningLotto.numbers.contains(numbers)) {
            List<Integer> commonNumbers;
            commonNumbers = winningLotto.numbers.stream()
                    .filter(numbers::contains)
                    .collect(Collectors.toList());

            if (commonNumbers.size() == 5 && numbers.contains(bonusNumber)) {
                return Winning.SECOND;
            }
            if (commonNumbers.size() == 5) {
                return Winning.THIRD;
            }
            if (commonNumbers.size() == 4) {
                return Winning.FOURTH;
            }
            if (commonNumbers.size() == 3) {
                return Winning.FIFTH;
            }
        }

        return Winning.LOSE;
    }
}
