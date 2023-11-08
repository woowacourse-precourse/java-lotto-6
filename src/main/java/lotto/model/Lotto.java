package lotto.model;

import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::containNumber)
                .count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public LottoRank checkRank(Lotto userLotto, int bonusNumber) {
        int matchCount = userLotto.countMatch(this);
        boolean matchBonus = userLotto.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE_OVER.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numbersCheck = new HashSet<>(numbers);
        if (numbersCheck.size() < 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number: numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_ARRANGE.getMessage());
            }
        }
    }
}
