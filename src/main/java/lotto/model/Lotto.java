package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validCountBoundary(numbers);
        validNumBoundary(numbers);
    }

    // TODO: 추가 기능 구현
    private void validCountBoundary(List<Integer> numbers){
        if (numbers.size() != 6) {
            System.out.println("숫자를 6개만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void validNumBoundary(List<Integer> numbers){
        if ((Collections.max(numbers) > 45) || (Collections.min(numbers) < 1)){
            throw new IllegalArgumentException();
        }
    }

    private void validReplica(List<Integer> numbers){

    }

}
