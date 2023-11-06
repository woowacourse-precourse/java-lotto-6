package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.ExceptionMessage;
import lotto.Controller.InputController;
import lotto.View.OuputView;

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
        try{
            validateLength(numbers);
            validateScope(numbers);
            validateDuplicates(numbers);
        } catch (IllegalArgumentException e){
            OuputView.printErrorMessage(e.getMessage());
            validate(InputController.inputWinningNumbers());
        }
    }
    private void validateLength(List<Integer> numbers){
        if (numbers.size() != ExceptionMessage.LOTTO_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_LENGTH);
        }
    }
    private  void validateScope(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < ExceptionMessage.MIN_NUM|| number > ExceptionMessage.MAX_NUM) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_SCOPE);
            }
        }
    }
    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_INPUT_NUMBER);
            }
            uniqueNumbers.add(number);
        }
    }
}
