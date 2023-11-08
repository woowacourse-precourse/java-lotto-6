package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUM_COUNT = 6;
    private static final int MAX_LOTTO = 45;
    private static final int MIN_LOTTO = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean compareNumbers(int number){
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validCountBoundary(numbers);
        validNumBoundary(numbers);
        validReplica(numbers);
    }

    // TODO: 추가 기능 구현
    private void validCountBoundary(List<Integer> numbers){
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(Valid.COUNT_BOUNDARY.getErrorMessage());
        }
    }

    private void validNumBoundary(List<Integer> numbers){
        if ((Collections.max(numbers) > MAX_LOTTO) || (Collections.min(numbers) < MIN_LOTTO)){
            throw new IllegalArgumentException(Valid.NUM_BOUNDARY.getErrorMessage());
        }
    }

    private void validReplica(List<Integer> numbers){
        if (numbers.stream().distinct().toList().size() != LOTTO_NUM_COUNT){
            throw new IllegalArgumentException(Valid.NUM_REPLICA.getErrorMessage());
        }
    }

}
