package lotto.model;

import lotto.message.ExceptionMessage;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSixElements(numbers);
        isNotDuplicated(numbers);
        isInRange(numbers);
    }

    private void isSixElements(List<Integer> numbers) {
        if(numbers.size()!= LOTTO_SIZE){
            ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.getMessage(LOTTO_SIZE);
        }
    }

    private void isNotDuplicated(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()){
            ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.getMessage();
        }
    }

    private void isInRange(List<Integer> numbers) {
        boolean isInRangeValue = numbers.stream().allMatch(number -> number > MIN_LOTTO_NUMBER && number < MAX_LOTTO_NUMBER);
        if(!isInRangeValue){
            ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }
}
