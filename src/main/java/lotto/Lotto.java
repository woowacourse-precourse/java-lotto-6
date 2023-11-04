package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicated(List<Integer> numbers){
        if(isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }
    }
    private boolean isDuplicated(List<Integer> numbers){
        return numbers.size() != duplicatedSize(numbers);
    }
    private Long duplicatedSize(List<Integer> numbers){
        return numbers.stream().distinct().count();
    }
}
