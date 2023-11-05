package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateHasSixSize(numbers);
        validateIsDuplicate(numbers);
    }

    private void validateHasSixSize(List<Integer> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateIsDuplicate(List<Integer> input) {
        long inputSize = input.size();
        long uniqueInputSize = input.stream()
                .distinct()
                .count();

        if (inputSize != uniqueInputSize) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않게 입력해야 합니다.");
        }
    }

    public String getLottoNumbers() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
