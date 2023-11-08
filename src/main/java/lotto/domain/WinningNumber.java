package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String numbers) {
        List<Integer> splitNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.numbers = splitNumbers;
    }

    public static WinningNumber consistOf(String numbers) {
        return new WinningNumber(numbers);
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }
}
