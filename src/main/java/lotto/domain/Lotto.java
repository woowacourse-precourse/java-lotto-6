package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }
    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public void validateNumberRange(List<Integer> numbers){
        if (numbers.stream().anyMatch(number-> number <0 || number>45)){
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int length(){
        return numbers.size();
    }

    public int get(int i){
        return numbers.get(i);
    }

    public boolean contains(int i) {
        return numbers.contains(i);
    }

}
