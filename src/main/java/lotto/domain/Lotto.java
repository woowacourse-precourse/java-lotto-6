package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.global.Validator;

public class Lotto {
    private final static String DELIMITER = ", ";
    private final static String OPEN_BRACKET = "[";
    private final static String CLOSE_BRACKET = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.lottoNumbersWithInteger(numbers);
    }

    public void printNumbers() {
        String joiningNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        System.out.println(OPEN_BRACKET + joiningNumbers + CLOSE_BRACKET);
    }

    public int compareWinningNumbers(List<Integer> winningNumbers) {
        int matchedCount = 0;

        for (int winningNumber : winningNumbers) {
            if (compareNumber(winningNumber)) {
                matchedCount++;
            }
        }

        return matchedCount;
    }

    public boolean compareNumber(int winningNumber) {
        for (int number : this.numbers) {
            if (number == winningNumber) {
                return true;
            }
        }

        return false;
    }
}
