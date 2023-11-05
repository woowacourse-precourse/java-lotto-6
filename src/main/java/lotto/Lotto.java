package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeInputtedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicatedNumber (List<Integer> numbers) {
        // 중복된 숫자가 있으면 예외가 발생
        List<Integer> InputtedNumber = new ArrayList<>();
        for(int num : numbers) {
            if(InputtedNumber.contains(num)){
                throw new IllegalArgumentException();
            } else if(!InputtedNumber.contains(num)){
                InputtedNumber.add(num);
            }
        }
    }

    private static void validateRangeInputtedNumber(List<Integer> numbers) {
        // 1 ~ 45 사이의 숫자가 아닐 경우 에러 처리
        for(int num : numbers){
            if(num < 1 || num > 45){
                throw new IllegalArgumentException();
            }
        }
    }
}
