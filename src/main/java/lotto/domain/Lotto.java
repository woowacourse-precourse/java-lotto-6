package lotto.domain;

import lotto.validation.Validation;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortListNaturalOrder(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLength(numbers,LOTTO_LENGTH);
        Validation.validateDuplicate(numbers);
        Validation.validateNumberListInRange(numbers,LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER);
    }

    private static List<Integer> sortListNaturalOrder(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<Integer>(list);
        Collections.sort(orderedList);
        return orderedList;
    }
}
