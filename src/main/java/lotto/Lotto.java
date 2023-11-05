package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkoutNumbers = new HashSet<>(numbers);
        if(checkoutNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return  numbers;
    }
}
