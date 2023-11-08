package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ExceptionMessage;
import lotto.constants.GameRule;
import lotto.utils.LottoGameException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameRule.LOTTO_LENGTH) {
            throw LottoGameException.withMessage(ExceptionMessage.LOTTO_LENGTH_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>();
        numbers.stream()
                .filter(number -> !unique.add(number))
                .findAny()
                .ifPresent(duplicate -> {
                    throw LottoGameException.withMessage(ExceptionMessage.LOTTO_DUPLICATE_ERROR);
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }

    public int getMatchCnt(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contain)
                .count();
    }
}
