package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateDuplicate(numbers);
        validateAscendingOrder(numbers);
        validateNumberInRange(numbers);
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAscendingOrder(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int countMatchingNumbers(Lotto targetLotto) {
        int count = 0;
        for (int number : numbers) {
            if (targetLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Rank determineRank(Lotto targetLotto, int bonusNumber) {
        int matchingCount = countMatchingNumbers(targetLotto);
        if (matchingCount == 5 && numbers.contains(bonusNumber)) {
            return Rank.MATCH_5_BONUS;
        }

        if (matchingCount == 3) {
            return Rank.MATCH_3;
        }
        if (matchingCount == 4) {
            return Rank.MATCH_4;
        }
        if (matchingCount == 5) {
            return Rank.MATCH_5;
        }
        if (matchingCount == 6) {
            return Rank.MATCH_6;
        }
        return null;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

