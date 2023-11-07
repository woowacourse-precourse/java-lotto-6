package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
        if(Collections.max(numbers)>Constants.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException();
        }
        if(Collections.min(numbers)<Constants.LOTTO_MIN_NUMBER){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
