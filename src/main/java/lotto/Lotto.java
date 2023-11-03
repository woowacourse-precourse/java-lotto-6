package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
