package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String numberString = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        sb.append(numberString);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public Rank checkWinning(WinningNumber winningNumber) {
        int matchCount = countMatchNumbers(winningNumber);
        boolean bonus = false;

        if (matchCount == 5) {
            bonus = this.numbers.contains(winningNumber.getBonus());
        }

        boolean finalBonus = bonus;

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatchCountEqual(matchCount))
                .filter(rank -> rank.isBonusEqual(finalBonus))
                .findAny()
                .orElse(Rank.NO_PRIZE);
    }

    private int countMatchNumbers(WinningNumber winningNumber) {
        return (int) winningNumber.getNumbers()
                .stream().filter(this.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> isNotDuplicated = new HashSet<>(numbers);
        if (isNotDuplicated.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
