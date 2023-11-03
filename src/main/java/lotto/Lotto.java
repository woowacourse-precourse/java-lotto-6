package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Rank compare(Lotto other, int bonusNumber) {
        float matchCount = getMatchCount(other, bonusNumber);
        for (Rank rank : Rank.values()) {
            if (rank.equals(matchCount)) {
                return rank;
            }
        }
        return null;
    }

    private float getMatchCount(Lotto other, int bonusNumber) {
        float matchCount = 0;
        for (int number : other.numbers) {
            if (numbers.contains(number)) {
                matchCount += 1;
            }
        }
        if (matchCount == 5 && numbers.contains(bonusNumber)) {
            matchCount += 0.5f;
        }
        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
