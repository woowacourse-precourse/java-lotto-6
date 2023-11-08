package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto(List<Integer> numbers, final int MIN_LOTTO_NUMBER, final int MAX_LOTTO_NUMBER, final int NUMBER_OF_LOTTO_NUMBERS) {
        validate(numbers, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, final int MIN_LOTTO_NUMBER, final int MAX_LOTTO_NUMBER, final int NUMBER_OF_LOTTO_NUMBERS) {
        validateCount(numbers, NUMBER_OF_LOTTO_NUMBERS);
        validateDuplicate(numbers, NUMBER_OF_LOTTO_NUMBERS);
        validateRange(numbers, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    private static void validateCount(final List<Integer> numbers, final int NUMBER_OF_LOTTO_NUMBERS) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] " + NUMBER_OF_LOTTO_NUMBERS + "개의 숫자여야 합니다.");
        }
    }

    private static void validateDuplicate(final List<Integer> numbers, final int NUMBER_OF_LOTTO_NUMBERS) {
        if (numbers.stream().distinct().count() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자여야 합니다.");
        }
    }

    private static void validateRange(final List<Integer> numbers, final int MIN_LOTTO_NUMBER, final int MAX_LOTTO_NUMBER) {
        if (numbers.stream().anyMatch(i -> i < MIN_LOTTO_NUMBER || i > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
