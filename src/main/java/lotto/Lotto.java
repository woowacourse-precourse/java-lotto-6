package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validDuplicateNumber(numbers);
        validNumbersBoundary(numbers);
        numbers.sort(Comparator.comparingInt(s -> s));
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        List<String> numbers = this.numbers.stream()
                .map(Object::toString)
                .toList();
        return "[" + String.join(", ", numbers) + "]";
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개이어야 합니다.");
        }
    }

    private void validDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validNumbersBoundary(final List<Integer> numbers) {
        boolean isBoundary = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (isBoundary) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        }
    }
}