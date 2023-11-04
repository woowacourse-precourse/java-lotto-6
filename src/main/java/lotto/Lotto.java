package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import user.User;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size()!= numbers.size();
    }
    // TODO: 추가 기능 구현

}
