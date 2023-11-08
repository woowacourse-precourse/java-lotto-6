package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.validation.WinningNumberValidation;

public class WinningNumber {
    private final Set<Integer> numbers;

    public WinningNumber(int[] numbers) {
        WinningNumberValidation.validateWinningNumber(numbers);
        this.numbers = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
