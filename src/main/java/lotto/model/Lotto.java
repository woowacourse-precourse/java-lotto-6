package lotto.model;

import lotto.model.MatchStatus;
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
        if (num == MatchStatus.THREE.getNumber()) {
            count[0]++;
        }
        if (num == MatchStatus.FOUR.getNumber()) {
            count[1]++;
        }
        if (num == MatchStatus.FIVE.getNumber() && !bonus) {
            count[2]++;
        }
        if (num == MatchStatus.FIVEANDBONUS.getNumber() && bonus) {
            count[3]++;
        }
        if (num == MatchStatus.SIX.getNumber()) {
            count[4]++;
        }
    }

    private boolean hasBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
