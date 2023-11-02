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
            System.out.println("[ERROR] 6개의 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            System.out.println("[ERROR] 중복된 숫자 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter((number) -> number >= 1 && number <= 45)
                .distinct()
                .count();

        if (count != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
