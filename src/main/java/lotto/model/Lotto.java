package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_SIZE = 6;
    private static final String SIX_NUMBER_ERROR = "[ERROR] 번호가 6자리가 아닙니다.";
    private static final String DISTINCT_NUMBER_ERROR = "[ERROR] 로또 번호에 중복된 숫자가 발생했습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(SIX_NUMBER_ERROR);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumber = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != distinctNumber.size()) {
            throw new IllegalArgumentException(DISTINCT_NUMBER_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


}
