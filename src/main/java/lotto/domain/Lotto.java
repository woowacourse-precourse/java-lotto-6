package lotto.domain;

import lotto.config.LottoConfig;
import lotto.config.WinningPrize;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int SIZE = LottoConfig.SIZE.getValue();
    private static final int RANGE_START = LottoConfig.RANGE_START.getValue();
    private static final int RANGE_END = LottoConfig.RANGE_END.getValue();
    private static final int FILTER_CONDITION = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public boolean checkDuplicates(int target) {
        return numbers.contains(target);
    }

    public WinningPrize compareWithAnswer(Lotto numbers, int bonus) {
        WinningPrize result = compareWithLotto(numbers);
        if (result == WinningPrize.THIRD_PLACE) {
            return checkBonus(bonus);
        }
        return result;
    }

    private WinningPrize compareWithLotto(Lotto target) {
        int match = 0;
        for (int number : target.numbers) {
            if (checkDuplicates(number)) {
                match++;
            }
        }
        return WinningPrize.getPrizeWithMatch(match);
    }

    private WinningPrize checkBonus(int bonus) {
        if (checkDuplicates(bonus)) {
            return WinningPrize.SECOND_PLACE;
        }
        return WinningPrize.THIRD_PLACE;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        int filterSize = numbers.stream()
                .filter(it -> it < RANGE_START || it > RANGE_END)
                .toList()
                .size();
        if (filterSize > FILTER_CONDITION) {
            throw new IllegalArgumentException();
        }
    }
}
