package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRepeat(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static void validateRepeat(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (Collections.frequency(numbers, i) > 1) {
                throw new IllegalArgumentException("Error! 각 로또번호는 unique 해야 합니다");
            }
        }
    }
}
