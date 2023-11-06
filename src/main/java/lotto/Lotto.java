package lotto;

import java.util.List;

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

    public Rank calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchingNumberCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        int matchingBonusNumberCount = (int) numbers.stream()
                .filter(number -> number == bonusNumber)
                .count();

        return Rank.findByMatchingNumber(matchingNumberCount, matchingBonusNumberCount);
    }
}
