package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNotDuplicated(numbers);
        validateNumbersInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateNotDuplicated(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberInRange);
    }

    private void validateNumberInRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer countMatchNumber(Lotto lotto) {
        List<Integer> copyOfLotto = new ArrayList<>(lotto.getNumbers());
        copyOfLotto.retainAll(numbers);
        return copyOfLotto.size();
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }
}
