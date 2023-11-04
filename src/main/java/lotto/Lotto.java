package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }
    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicated(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            if (numbers.indexOf(numbers.get(i)) != numbers.lastIndexOf(numbers.get(i))) throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
