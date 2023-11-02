package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.ExceptionMessage;
import lotto.View.InputVIew;

public class Lotto {
    private final List<Integer> numbers;
    //TODO : InputView에서 가져옴
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        try {
            validateLength(numbers);
            validateNumbers(numbers);
            validateDuplicates(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            InputVIew.inputWinningNumbers();
        }

    }
    private void validateLength(List<Integer> numbers){
        if (numbers.size() != ExceptionMessage.LOTTO_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_LENGTH);
        }
    }
    private  void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < ExceptionMessage.MIN_NUM|| number > ExceptionMessage.MAX_NUM) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE);
            }
        }
    }
    private  void validateDuplicates(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        for (Integer number : numbers) {
            if (seen.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_INPUT_NUMBER);
            }
            seen.add(number);
        }
    }

}
