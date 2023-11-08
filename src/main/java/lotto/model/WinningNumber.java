package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.validation.WinningNumberValidation;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(int[] numbers) {
        WinningNumberValidation.validateWinningNumber(numbers);
        this.numbers = Arrays.stream(numbers).boxed().toList();
    }

    public boolean isDuplicated(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
