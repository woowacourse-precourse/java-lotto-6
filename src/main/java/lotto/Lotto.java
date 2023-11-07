package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력 가능합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int match(Lotto lotto) {
        return Math.toIntExact(numbers.stream()
                .filter(lotto::contains)
                .count());
    }
}
