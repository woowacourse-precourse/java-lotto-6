package lotto.winning;

import static lotto.Settings.MAXIMUM;
import static lotto.Settings.MINIMUM;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class WinningNumbers {
    protected List<Integer> convertInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    protected final Predicate<List<Integer>> isCorrectRange = input ->
            input.stream().mapToInt(Integer::intValue).min().orElse(Integer.MIN_VALUE) >= MINIMUM.getNumber() &&
                    input.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE) <= MAXIMUM.getNumber();
}
