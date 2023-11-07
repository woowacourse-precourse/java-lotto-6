package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.constant.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);
        validateLottoNumberAscending(numbers);
    }

    private static void validateLottoNumberAscending(List<Integer> numbers) {
        List<Integer> ascendingNumbers = new ArrayList<>(numbers);
        Collections.sort(ascendingNumbers);
        if (!ascendingNumbers.equals(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(i -> (i >= MIN_LOTTO_NUMBER && i <= MAX_LOTTO_NUMBER))) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        if (!numbers.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contain(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public Integer size() {
        return numbers.size();
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}