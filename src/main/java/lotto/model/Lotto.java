package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validLength(numbers);
        validDuplication(numbers);
    }

    private void validLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 수는 6개여야 한다.");
        }
    }

    private void validDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(("[ERROR] 로또 번호는 중복되어선 안된다."));
        }
    }

    @Override
    public String toString() {
        return "[" + this.numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
