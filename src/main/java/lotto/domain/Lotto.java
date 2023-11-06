package lotto.domain;

import lotto.constant.Errors;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        Collections.sort(numbers);

        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Errors.WINNING_NUMBER_WRONG_SIZE_MESSAGE.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int i : numbers){
            if (i < 1 || i > 45){
                throw new IllegalArgumentException(Errors.WINNING_NUMBER_WRONG_RANGE_MESSAGE.getErrorMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers){
        for(int i = 1; i < numbers.size(); i++){
            if(numbers.get(i) == numbers.get(i-1)){
                throw new IllegalArgumentException(Errors.WINNIG_NUMBER_DUPLICATE_MESSAGE.getErrorMessage());
            }
        }
    }

    // TODO: 추가 기능 구현
}
