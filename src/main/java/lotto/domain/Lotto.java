package lotto.domain;

import lotto.exception.OverLappingNumbersException;
import lotto.exception.RangeLottoNumberException;

import java.util.List;

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

    public boolean numbersMatchWonLottoNumber(WonLotto wonLotto) {
        for (Integer lottoNumber : numbers) {
            if (lottoNumber.equals())
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
