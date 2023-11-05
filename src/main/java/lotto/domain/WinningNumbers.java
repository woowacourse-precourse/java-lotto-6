package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private static final int WINNING_NUMBERS_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicatedNumber(numbers);
        validateBonusNumber(bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 %d개여야 한다."
                    .formatted(WINNING_NUMBERS_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        long numbersSizeWithValidRange = numbers.stream()
                .filter(number -> (MIN_NUMBER <= number && number <= MAX_NUMBER))
                .count();
        if (numbers.size() != numbersSizeWithValidRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 %d이상 %d이하여야 한다."
                    .formatted(MIN_NUMBER, MAX_NUMBER));
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 달라야 한다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 %d이상 %d이하여야 한다."
                    .formatted(MIN_NUMBER, MAX_NUMBER));
        }
    }

    public Rank determineRank(Lotto lotto) {
        long matchCount = numbers.stream()
                .filter(lotto::contains)
                .count();
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchesCondition(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(Rank.MISS);
    }
}
