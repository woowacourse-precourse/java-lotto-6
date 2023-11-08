package lotto;

import java.util.LinkedList;
import java.util.List;

public class Lotto {
    private static final String DUPLICATE_NUMBER = "중복되는 숫자가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers) {
        List<Integer> proveNumber = new LinkedList<>();
        for (Integer number : numbers) {
            if (!proveNumber.contains(number)) {
                proveNumber.add(number);
            }
        }
        if (proveNumber.size() != 6)
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
    }
    // TODO: 추가 기능 구현
}
