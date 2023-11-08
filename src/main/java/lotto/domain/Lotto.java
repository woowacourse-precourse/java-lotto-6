package lotto.domain;

import java.util.List;
import lotto.util.GenerationUtil;
import lotto.util.ValidationUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationUtil.isValidNumber(numbers);
    }

    // TODO: 추가 기능 구현
    public static Lotto Create() {
        return new Lotto(GenerationUtil.generateRandomNumbers());
    }
}
