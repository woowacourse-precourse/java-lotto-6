package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 정확히 6개여야 합니다.");
        }
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
        boolean hasInvalidNumber = distinctNumbers.stream().anyMatch(num -> num < 1 || num > 45);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}