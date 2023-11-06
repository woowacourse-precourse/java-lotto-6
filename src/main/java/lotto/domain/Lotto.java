package lotto.domain;

import lotto.exception.OverLappingNumbersException;
import lotto.exception.RangeLottoNumberException;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Constant.MAX_RANGE;
import static lotto.domain.Constant.MIN_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        overlappingNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void overlappingNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateOverlappingNubers(numbers, i);
        }
    }

    private void validateOverlappingNubers(List<Integer> numbers, int index) {
        Integer overlappingNumbers = numbers.get(index);
        for (int j = index + 1; j < numbers.size(); j++) {
            Integer validatedNumber = numbers.get(j);
            if (overlappingNumbers.equals(validatedNumber)) {
                throw new OverLappingNumbersException();
            }
        }
    }

    public void numberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
                throw new RangeLottoNumberException();
            }
        }
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    public int numbersMatchWonLottoNumber(WonLotto wonLotto) {
        int count = 0;
        for (int num : numbers) {
            if (wonLotto.isContain(num)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
