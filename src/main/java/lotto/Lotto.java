package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> setNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (setNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getErrorMessage());
            }
            setNumbers.add(number);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i));
            System.out.print(", ");
        }
        System.out.print(numbers.get(numbers.size() - 1));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
