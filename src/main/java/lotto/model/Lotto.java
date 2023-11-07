package lotto.model;

import lotto.model.enums.LottoSpec;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNumberInRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    protected void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    protected void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    protected void validateNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoSpec.MIN_NUMBER.getValue() || number > LottoSpec.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
