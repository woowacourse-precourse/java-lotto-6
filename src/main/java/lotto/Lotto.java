package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        sortedByAsc(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortedByAsc(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }
}
