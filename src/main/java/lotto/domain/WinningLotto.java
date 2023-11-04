package lotto.domain;

import java.util.List;

import static lotto.exception.InputNumberException.*;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<String> numbers) {
        inputValidate(numbers);
        this.numbers = numbers.stream()
                .map(Integer::valueOf)
                .toList();
    }
}
