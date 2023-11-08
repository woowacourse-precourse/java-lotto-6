package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.service.exception.IllegalArgumentExceptionHandler;
import lotto.service.exception.InputErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        verifyDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void verifyDuplication(List<Integer> winningNumber){
        Set<Integer> checkDuplication = new HashSet<>();
        for(int number : winningNumber){
            if(checkDuplication.contains(number)){
                throw new IllegalArgumentExceptionHandler(InputErrorMessage.DUPLICATE_NUMBER);
            }
            checkDuplication.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
