package lotto.domain;

import lotto.constants.ErrorMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validNumberUnique(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.ERR_INPUT_LIST_SIZE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(ErrorMessages.ERR_OUT_OF_BOUND.getMessage());
            }
        }
    }

    private void validNumberUnique(List<Integer> numbers) {
        boolean[] uniqueChecker = new boolean[46];
        for (int number : numbers){
            if (uniqueChecker[number]) {
                throw new IllegalArgumentException(ErrorMessages.ERR_DUPLICATED_NUMBER.getMessage());
            }
            uniqueChecker[number] = true;
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
