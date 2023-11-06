package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateUniqueNumbers(numbers);
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

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 번호만 필요합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("로또 번호가 모두 달라야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
