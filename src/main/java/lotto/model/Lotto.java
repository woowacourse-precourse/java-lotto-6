package lotto.model;

import lotto.validator.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.isInvalidSize(numbers);
        LottoValidator.isDuplicated(numbers);
        LottoValidator.isInvalidNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public void compareLottoWithWinningLotto(List<Integer> winningNumbers, int[] sameNumberCount, int bonusNumber) {
        int count = countSameNumber(winningNumbers);
        boolean bonus = hasBonusNumber(numbers, bonusNumber);
        saveCount(count, sameNumberCount, bonus);
    }

    private int countSameNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }

    private void saveCount(int num, int[] count, boolean bonus) {
        if (num == 3) {
            count[0]++;
        }
        if (num == 4) {
            count[1]++;
        }
        if (num == 5 && !bonus) {
            count[2]++;
        }
        if (num == 5 && bonus) {
            count[3]++;
        }
        if (num == 6) {
            count[4]++;
        }
    }

    private boolean hasBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
