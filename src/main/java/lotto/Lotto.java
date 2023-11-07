package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> hashNumbers = new HashSet<>(numbers);
        if(hashNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
}
