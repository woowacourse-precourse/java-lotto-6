package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException();
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank checkWinning(Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) numbers.stream().filter(winningLotto.numbers::contains).count();
        boolean bonusMatch = numbers.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    // TODO: 추가 기능 구현
}
