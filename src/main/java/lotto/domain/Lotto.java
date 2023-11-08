package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        numbers.stream().forEach(num -> {
            if (1 > num || num > 45) {
                throw new IllegalArgumentException("1~45 숫자를 입력해주세요");
            }
        });
    }

    public void printLotto() {
        System.out.println(numbers.stream().map(Objects::toString).collect(Collectors.joining(", ", "[", "]")));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
