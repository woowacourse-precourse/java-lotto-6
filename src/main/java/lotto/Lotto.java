package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNotDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotDuplicated(List<Integer> numbers) {
        if (duplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicated(List<Integer> numbers) {
        long distinctSize = numbers.stream().
                distinct().
                count();
        return numbers.size() != distinctSize;
    }

    public RANK rank(Lotto winningLotto, int bonus) {
        int matches = (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        boolean bonusMatched = numbers.contains(bonus);
        return RANK.from(matches, bonusMatched);
    }
}
