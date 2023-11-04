package lotto;

import lotto.global.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.global.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_IS_NOT_SIX.getMessage());
        }

        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicateNumber(final List<Integer> numbers) {
        List<Integer> removedDuplicateNumbers = numbers.stream()
                .distinct()
                .toList();

        return numbers.size() != removedDuplicateNumbers.size();
    }

    public WinningLotto compareWinningNumbers(final List<Integer> winningNumbers, final Integer bonus) {
        int matchWinningNumbersCount = this.countWinningNumbers(winningNumbers);
        int matchBonusCount = this.countBonusMatch(bonus);

        return Arrays.stream(WinningLotto.values())
                .filter(winningLotto -> winningLotto.getLottoRank(matchWinningNumbersCount, matchBonusCount))
                .findFirst()
                .orElse(WinningLotto.LAST_PLACE);
    }

    private int countWinningNumbers(final List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    private int countBonusMatch(final Integer bonus) {
        if (this.numbers.contains(bonus)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
