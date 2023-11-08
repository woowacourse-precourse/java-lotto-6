package lotto.model;

import lotto.constant.message.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int number : numbers){
            if(hashSet.contains(number)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
            }
            hashSet.add(number);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
