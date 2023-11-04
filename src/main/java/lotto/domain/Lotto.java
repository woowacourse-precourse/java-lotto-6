package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public Ranking getRanking(List<Integer> winningNumbers, int bonusNumber) {
        int sameInWinningNumbers = (int) numbers.stream().filter(n -> winningNumbers.contains(n)).count();
        if (sameInWinningNumbers == 6) {
            return Ranking.FIRST;
        }
        if (sameInWinningNumbers == 5 && numbers.contains(bonusNumber)) {
            return Ranking.SECOND;
        }
        if (sameInWinningNumbers == 5) {
            return Ranking.THIRD;
        }
        if (sameInWinningNumbers == 4) {
            return Ranking.FOURTH;
        }
        if (sameInWinningNumbers == 3) {
            return Ranking.FIFTH;
        }
        return Ranking.NONE;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
