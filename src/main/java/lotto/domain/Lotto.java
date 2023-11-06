package lotto.domain;

import lotto.constant.ConstantValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.message.ExceptionMessage.INPUT_NOT_DISTINCT;
import static lotto.message.ExceptionMessage.NUMBER_SIZE_NOT_MATCH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != ConstantValue.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_NOT_MATCH);
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers){
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(INPUT_NOT_DISTINCT);
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public int compare(Lotto lotto){
        return (int) numbers.stream()
                .map(lotto::contains)
                .filter(isMatch -> isMatch)
                .count();
    }
}
