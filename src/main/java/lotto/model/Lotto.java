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

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        consistOfLottoSize(numbers);
        isInRange(numbers);
        isNotDuplicated(numbers);
    }

    private void consistOfLottoSize(List<Integer> numbers) {
        if(numbers.size()!= LOTTO_SIZE){
            ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.throwException(LOTTO_SIZE);
        }
    }

    private void isInRange(List<Integer> numbers) {
        boolean isInRangeValue = numbers.stream().allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
        if(!isInRangeValue){
            ExceptionMessage.IS_NOT_IN_RANGE.throwException(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

    private void isNotDuplicated(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()){
            ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.throwException();
        }
    }
}
