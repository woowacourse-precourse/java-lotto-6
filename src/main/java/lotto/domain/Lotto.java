package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertSortedAndUnmodifiable(numbers);
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
        return numbers.size() != Constants.LOTTO_NUMBER_COUNT;
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    void validateNumberRange(int number) {
        if(isOutRangeNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isOutRangeNumber(int number) {
        return number < Constants.MIN_LOTTO_NUMBER
                || number > Constants.MAX_LOTTO_NUMBER;
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (containDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean containDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number))
                return true;
        }
        return false;
    }

    private List<Integer> convertSortedAndUnmodifiable(List<Integer> numbers) {
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        Collections.sort(modifiableNumbers);
        return Collections.unmodifiableList(modifiableNumbers);
    }

    protected int countMatchedNumber(Lotto lotto) {
        int matchedCount = 0;

        for (Integer comparedNumber : lotto.numbers) {
            if (containNumber(comparedNumber)) {
                matchedCount++;
            }
        }

        return matchedCount;
    }

    public boolean containNumber(int comparedNumber) {
        int foundIndex = Collections.binarySearch(numbers, comparedNumber);
        return foundIndex >= 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}