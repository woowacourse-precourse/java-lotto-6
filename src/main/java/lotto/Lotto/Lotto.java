package lotto.Lotto;

import lotto.Print.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        //sortOrder(numbers);
        this.numbers = numbers;
    }

    private void sortOrder(List<Integer> numbers){
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumberRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException(ErrorMessage.INAVLID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers){
        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if(duplicateCheck.size() < 6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String printNumbers(){

        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}