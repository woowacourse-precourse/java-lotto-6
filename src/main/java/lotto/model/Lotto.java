package lotto.model;

import lotto.service.IssueLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.controller.InputController.validator;
import static lotto.controller.InputController.winningNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        List<Integer> checking = numbers.stream().distinct().toList();
        if (numbers.size() != checking.size()) {
            throw new IllegalArgumentException();
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
