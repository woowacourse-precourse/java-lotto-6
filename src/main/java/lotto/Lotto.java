package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { //생성자
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_6_SIZE.getErrorMessage());
        }
        Set<Integer> validateDuplication = new HashSet<>(numbers);
        if (numbers.size() != validateDuplication.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE.getErrorMessage());
        }
        for (int elements : numbers) {
            if (1 > elements || elements > 45) {
                throw new IllegalArgumentException(ErrorMessage.RANGE_IN_1_TO_45.getErrorMessage());
            }
        }
    }
    // TODO: 추가 기능 구현
}
