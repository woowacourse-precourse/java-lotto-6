package lotto.domain;

import lotto.exception.OverLappingNumbersException;
import lotto.exception.RangeLottoNumberException;

import java.util.List;

import static lotto.domain.Constant.MIN_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numberRange(numbers);
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

    private void numberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_RANGE || number > Constant.MAX_RANGE) {
                throw new RangeLottoNumberException();
            }
        }
    }

    public int countSameNumber(Lotto lotto) {
        int count = 0;
        for (int num : numbers) {
            if (lotto.hasNumber(num)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasNumber(Integer userLottoNumber) {
        for(Integer lottoNumber: numbers) {
            if (lottoNumber.equals(userLottoNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
