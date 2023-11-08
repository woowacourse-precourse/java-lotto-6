package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final String ERROR_MESSAGE = "[ERROR] ";
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "6개의 숫자가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<Integer>();
        for(int number : numbers) {
            if(!unique.add(number)){
                throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 값이 있습니다.");
            }
        }

    }

    private void validateNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        for(int number : numbers) {
            if(number < MIN_NUMBER || number > MAX_NUMBER){
                throw new IllegalArgumentException(ERROR_MESSAGE + "값이 범위를 벗어납니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
