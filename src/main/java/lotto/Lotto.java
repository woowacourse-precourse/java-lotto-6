package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSizeIs6(numbers);
        validateNumbersRangeFrom1To45(numbers);
        validateNumbersNotDuplicate(numbers);
    }

    private void validateNumbersSizeIs6(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRangeFrom1To45(List<Integer> numbers) {
        for (int number: numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumbersNotDuplicate(List<Integer> numbers) {
        Set<Integer> winningNumberSet = Set.copyOf(numbers);
        if (winningNumberSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        for (int i = 0; i < sortedNumbers.size()-1; i++) {
            result.append(sortedNumbers.get(i));
            result.append(", ");
        }
        result.append(sortedNumbers.get(sortedNumbers.size()-1));
        result.append("]");
        System.out.println(result);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
