package lotto.model;

import lotto.model.Number;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final static int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
