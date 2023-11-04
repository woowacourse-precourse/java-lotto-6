package lotto.Model;

import lotto.Constants;

import java.util.List;

import static lotto.Constants.*;

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
        for(Integer number : numbers) {
            if(!(number >= RANDOM_START_NUM && number <= RANDOM_END_NUM)) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }
        }
    }
}
