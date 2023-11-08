package lotto.Model;

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
        for (Integer number : numbers) {
            if (!(number >= Numbers.ONE.getValue() && number <= END_NUMBER)) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }
        }
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue(int index) {
        return numbers.get(index);
    }

    public boolean isSameNumber(int value) {
        return numbers.contains(value);
    }

    public String toString(){
        return numbers.toString();
    }
}
