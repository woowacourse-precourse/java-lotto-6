package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeNumbersValidator {
    public List<Integer> numbers;
    private List<String> splitedNumbers;

    public void validate(String numbers) {
        canSplitComma(numbers);
        isNumber();
        isCorrectNumber();
        isDuplicated();
    }

    private void canSplitComma(String numbers) {
        try {
            splitedNumbers = Arrays.asList(numbers.split(","));
            if (splitedNumbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("6개로 나누어지지 않는 문제");
        }
    }

    private void isNumber() {
        try {
            this.numbers = splitedNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void isCorrectNumber() {
        for (int number : this.numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void isDuplicated() {
        if (this.numbers.stream().distinct().count() != this.numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
