package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 6개가 만들어지지 않았습나다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public void sort() {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(numbers.toArray());
    }
}

