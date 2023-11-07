package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numberLengthvaildation(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean numberLengthvaildation(List<Integer> numbers){
        if(numbers.size() != 6){
            return true;
        }
        return false;
    }
    // TODO: 추가 기능 구현
}
