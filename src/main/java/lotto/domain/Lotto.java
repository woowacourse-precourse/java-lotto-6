package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.*;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.Lotto.MAX_NUMBER;
import static lotto.constants.Lotto.MIN_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(new ArrayList<>(numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        rangeCheck(numbers);
        duplicateCheck(numbers);
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_ENOUGH_SIZE.getLabeledErrorMessage());
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
                throw new InvalidLottoNumberException(OUT_OF_LOTTO_NUMBER_RANGE.getLabeledErrorMessage());
            }
        });
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Object> duplicateCheck = new HashSet<>();
        for (Integer number : numbers) {
            if (!duplicateCheck.add(number)) {
                throw new InvalidLottoNumberException(DUPLICATE_LOTTO_NUMBER.getLabeledErrorMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        StringJoiner format = new StringJoiner(", ", "[", "]");
        numbers.forEach(number -> format.add(String.valueOf(number)));

        return format.toString();
    }
}
