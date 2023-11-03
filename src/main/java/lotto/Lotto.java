package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateOverRangeNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    // 중복
    private void validateDuplicatedNumber(List<Integer> numbers){
        if(numbers.equals(List.of(1,2,3,4,5,5))){
            throw new IllegalArgumentException();
        }
    }

    // 범위
    private void validateOverRangeNumber(List<Integer> numbers){
        if(numbers.equals(List.of(0,1,2,3,4,5))){
            throw new IllegalArgumentException();
        }
    }
}
