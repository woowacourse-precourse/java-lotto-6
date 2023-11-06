package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int compare(List<Integer> winningLotto) {
        int count = 0;
        for (Integer winningNumber : winningLotto) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    // TODO: 추가 기능 구현
}
