package lotto.domain;

import lotto.util.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateSameNumberCheckStart(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static void validateSameNumberCheckStart(List<Integer> numbers){
        for(int i=0; i<numbers.size()-1; i++) {
            for(int j = i+1; j<numbers.size(); j++)
                validateSameNumberCheckFinish(numbers.get(i), numbers.get(j));

        }
    }

    public static void validateSameNumberCheckFinish(Integer num1, Integer num2){
        if(num1 == num2){
            throw new IllegalArgumentException("로또의 숫자가 중복되었습니다. 프로그램 오류입니다");
        }
    }
}
