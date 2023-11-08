package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String numbers) {
        this.numbers = verification(numbers);
    }

    public List<Integer> createWinningNumbers(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int winningNumberCount(Lotto lotto) {

        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }
}