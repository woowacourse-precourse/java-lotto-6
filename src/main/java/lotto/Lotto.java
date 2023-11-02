package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer integer) {
        return numbers.contains(integer);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 입니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter((number) -> number >= 1 && number <= 45)
                .distinct()
                .count();

        if (count != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다.");
        }
    }
}
