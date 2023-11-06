package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_LENGTH.toString());
        }
        if(containsDuplicateNumber(numbers)){
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE.toString());
        }
    }
    private boolean containsDuplicateNumber(List<Integer> numbers){
        return new HashSet<>(numbers).size() != numbers.size();
    }
    public List<Integer> getLotto(){
        return numbers;
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
}
