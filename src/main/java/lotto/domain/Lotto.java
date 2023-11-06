package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> generatedNumbers) {
        validate(generatedNumbers);
        this.numbers = sortNumbersToAsc(generatedNumbers);
    }

    private void validate(List<Integer> numbers) {
        // 숫자가 6개인지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private List<Integer> sortNumbersToAsc(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}

