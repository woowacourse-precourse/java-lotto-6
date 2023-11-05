package lotto.domain;

import java.util.List;
import lotto.util.ExceptionMessage;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
