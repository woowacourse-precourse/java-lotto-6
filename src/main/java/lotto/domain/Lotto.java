package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sorted = lottoNumSort(numbers);
        this.numbers = sorted;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개여야합니다.");
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        numbers.stream().forEach(num -> {
            if (1 > num || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }

    public void printLotto() {
        System.out.println(numbers.stream().map(Objects::toString).collect(Collectors.joining(", ", "[", "]")));
    }

    public List<Integer> lottoNumSort(List<Integer> beforeSort) {
        return beforeSort.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
