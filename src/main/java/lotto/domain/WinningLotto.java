package lotto.domain;

import java.util.List;

import static lotto.exception.InputNumberException.*;
import static lotto.exception.LottoNumberException.*;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<String> input) {
        inputValidate(input);
        this.numbers = input.stream()
                .map(Integer::valueOf)
                .toList();
        lottoValidate(numbers);
    }

    public void plusBonusNumber(List<String> bonus) {
        inputValidate(bonus);
        Integer number = Integer.parseInt(bonus.get(0));
        numberDuplicateValidate(number);
    }

    private void numberDuplicateValidate(Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
