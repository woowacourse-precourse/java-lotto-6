package lotto.lotto.model;

import java.util.Collections;
import java.util.List;

import lotto.util.error.CustomError;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sorting(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(CustomError.INPUT_MAX_NUMBER.getError());
        }
    }

    // TODO: 추가 기능 구현
    public String toString(){
        return numbers.toString();
    }

    private void sorting(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public int length(){
        return numbers.size();
    }

    public int get(int index){
        return numbers.get(index);
    }
}
