package lotto;

import constant.Rank;
import java.util.Collections;
import java.util.List;
import validator.NumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberValidator.sizeValidate(numbers);
        NumberValidator.duplicateValidate(numbers);
        NumberValidator.matchRangeValidate(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public Rank getRank(List<Integer> winningNumbers, int bonus) {
        int matchingCount = getMatchingCounts(winningNumbers);
        boolean matchingBonus = getMatchingBonus(bonus);

        return findRank(matchingCount, matchingBonus);
    }

    private int getMatchingCounts(List<Integer> winningNumbers) {
        int matchingCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private boolean getMatchingBonus(int bonus) {
        return numbers.contains(bonus);
    }

    private Rank findRank(int matchingCount, boolean matchingBonus) {
        if (matchingBonus && matchingCount == 5) {
            return Rank.SECOND;
        }

        if (matchingCount < 3) {
            return Rank.NONE;
        }
        switch (matchingCount) {
            case 3:
                return Rank.FIFTH;
            case 4:
                return Rank.FOURTH;
            case 5:
                return Rank.THIRD;
            case 6:
                return Rank.FIRST;
            default:
                throw new IllegalArgumentException("Invalid matchingCount and matchingBonus combination.");
        }
    }
}
