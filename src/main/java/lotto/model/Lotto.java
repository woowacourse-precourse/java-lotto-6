package lotto.model;


import lotto.util.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicated(numbers);
        rightRange(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_COUNT_ERROR.getMessage());
        }
    }
    private void duplicated(List<Integer> numbers){
        Set<Integer> setNumbers = new HashSet<>(numbers);

        if(numbers.size() != setNumbers.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void rightRange(List<Integer> numbers) {
        int startNumber = 1;
        int finishNumber = 45;
        numbers.stream()
                .filter(number -> number < startNumber || number > finishNumber).forEach(number -> {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
