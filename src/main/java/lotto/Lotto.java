package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateWinningNumbers(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateUniqueNumbers(winningNumbers);
        validateNumbersSize(winningNumbers);
        validate(winningNumbers);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.lengthException();
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        for (int winningNumber = 0; winningNumber < numbers.size(); winningNumber++) {
            if(numbers.get(winningNumber) < 1 || numbers.get(winningNumber) > 45) {
                ExceptionMessage.sizeException();
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            uniqueNumbers.add(numbers.get(i));
        }
        if (uniqueNumbers.size() != 6) {
            ExceptionMessage.existException();
            throw new IllegalArgumentException();
        }
    }
    public static void validateWinningResult(List<Integer> numbers, int bonisNumber) {
        if (numbers.contains(bonisNumber)) {
            ExceptionMessage.existException();
            throw new IllegalArgumentException();
        }
    }
}
