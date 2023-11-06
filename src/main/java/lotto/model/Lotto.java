package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> checking = new ArrayList<>();
        checking = numbers.stream().distinct().collect(Collectors.toList());

        if (numbers.size() != checking.size()) {
            throw new IllegalArgumentException("중복되지 않는 6개의 숫자를 입력해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
