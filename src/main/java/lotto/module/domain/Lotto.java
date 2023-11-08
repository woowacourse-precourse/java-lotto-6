package lotto.module.domain;

import static lotto.global.constant.Game.LOTTO_SIZE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateDuplication(List<Integer> input) {
        Set<Integer> numbers = input.stream().collect(Collectors.toSet());
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("");
        }
    }
}
