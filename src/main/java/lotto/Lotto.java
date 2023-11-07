package lotto;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLengthLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLengthLotto(List<Integer> numbers) {
        if (numbers.size() != Lotto_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeLotto(List<Integer> numbers){

    }

    private void validateOrderLotto(List<Integer> numbers){

    }

    public String convertToString(){
        List<String>numbersString = new ArrayList<>();
        for(Integer num : numbers){
            numbersString.add(num.toString());
        }
        return String.join(", ", numbersString);
    }

}
