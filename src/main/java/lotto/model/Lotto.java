package lotto.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.enums.Prize;

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

    // TODO: 추가 기능 구현
    public int getPrize(List<Integer> winningNumbers, int bonusNumber) {
        int winCount = checkWinCount(winningNumbers);
        boolean isSecondWinner = checkBonusNumber(bonusNumber);
        return Prize.getPrize(winCount, isSecondWinner);
    }

    private int checkWinCount(List<Integer> winningNumbers) {
        long winCount = numbers.stream()
                .filter(number -> winningNumbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
        return Math.toIntExact(winCount);
    }

    private boolean checkBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
