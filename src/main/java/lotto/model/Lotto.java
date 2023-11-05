package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNotDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateNotDuplicated(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < numbers.size()) {
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
