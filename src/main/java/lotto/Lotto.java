package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    static int lottoRangeFirstNum = 1;
    static int lottoRangeLastNum = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isWithinRange(numbers);
        hasDuplicateNum(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isWithinRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (!(num >= lottoRangeFirstNum && num <= lottoRangeLastNum)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void hasDuplicateNum(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
