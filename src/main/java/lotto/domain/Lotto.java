package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConstants.NUMBER_MAX;
import static lotto.domain.LottoConstants.NUMBER_MIN;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private ArrayList<Integer> sort(List<Integer> numbers) {
        ArrayList<Integer> modifiableList = new ArrayList<>(numbers);
        Collections.sort(modifiableList);
        return modifiableList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateUnder6Length(numbers);
        validateDuplicateNumbers(numbers);
        validate1To45Number(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateUnder6Length(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBERS_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OVER_SIX_NUMBERS_LENGTH.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            checkAndThrowIfDuplicate(number, set);
        }
    }

    private void checkAndThrowIfDuplicate(int number, HashSet<Integer> set) {
        if (!set.add(number)) {
            throw new IllegalArgumentException(ErrorMessage.INCLUDE_DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validate1To45Number(List<Integer> numbers) {
        for (int number : numbers) {
            checkAndThrowIfOutOfRange(number);
        }
    }

    private void checkAndThrowIfOutOfRange(int number) {
        if (number < NUMBER_MIN.getValue() || number > NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
