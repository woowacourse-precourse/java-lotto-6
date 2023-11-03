package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto implements Constraints {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
}
