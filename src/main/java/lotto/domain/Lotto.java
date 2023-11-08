package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.message.Error;
import lotto.util.Validation;

public class Lotto {

    private static final int lottoNumberCount = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        //numbers가 수정 불가능할 경우를 처리하기 위해 배열을 복사하여 사용

        validate(numbersCopy);
        sortAscending(numbersCopy);
        this.numbers = Collections.unmodifiableList(numbersCopy);
    }

    private void sortAscending(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (!Validation.hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_COUNT.getMessage(lottoNumberCount));
        }
        if (Validation.hasDuplicate(numbers)) {
            throw new IllegalArgumentException(Error.DUPLICATE_NUMBER_EXIST.getMessage());
        }
        if (!Validation.hasCorrectRange(numbers)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
