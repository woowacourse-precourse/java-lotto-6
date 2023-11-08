package lotto;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionHandler.ERROR_04);
        } else if (Lists.newArrayList(Sets.newHashSet(numbers)).size() != 6) {
            throw new IllegalArgumentException(ExceptionHandler.ERROR_06);
        }
        for (Integer i : numbers) {
            if ((i < 1) || (i > 45)) {
                throw new IllegalArgumentException(ExceptionHandler.ERROR_05);
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
