package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException("[ERROR] 로또 번호 입력이 null입니다.");
        }
        validateSize(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER);
        if (outOfRange) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + MIN_LOTTO_NUMBER + "과 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public boolean isMatchBonus(WinningLotto winningLotto) {
        return numbers.contains(winningLotto.getBonusNumber());
    }
}

