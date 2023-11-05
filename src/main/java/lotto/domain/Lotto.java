package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstraint;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LottoConstraint.LOTTO_NUMBER_COUNT.getValue();
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (containOutRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean containOutRangeNumber(List<Integer> numbers) {
        //TODO : for문으로 바꾸는 것을 고려
        return numbers.stream().anyMatch(this::isOutRangeNumber);
    }

    private boolean isOutRangeNumber(int number) {
        return number < LottoConstraint.MIN_LOTTO_NUMBER.getValue()
                || number > LottoConstraint.MAX_LOTTO_NUMBER.getValue();
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if(containDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean containDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if(!uniqueNumbers.add(number))
                return true;
        }
        return false;
    }

    public int countMatchedNumber(Lotto lotto) {
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
