package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public long matchCount(Lotto myLotto) {
        return numbers.stream()
                .filter(myLotto::contain)
                .count();
    }

    public boolean contain(Integer num) {
        return numbers.contains(num);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
