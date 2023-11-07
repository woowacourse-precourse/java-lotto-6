package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateDuplication(numbers);
    }
    private void validateSize(int numbers) {
        if (numbers != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        numbers.stream().forEach(uniqueNumbers::add);
        validateSize(uniqueNumbers.size());
    }
}
