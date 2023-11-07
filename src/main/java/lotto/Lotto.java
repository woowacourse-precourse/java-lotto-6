package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers = numbers.stream()
                .distinct()
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 중복없이 입력하세요.");
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력하세요.");
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().toList();
    }
}
