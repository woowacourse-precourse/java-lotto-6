package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numberLengthvaildation(numbers)) {
            throw new IllegalArgumentException();
        }
        else if (numberSizeVaildation(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean numberLengthvaildation(List<Integer> numbers){
        if(numbers.size() != 6){
            return true;
        }
        return false;
    }

    private boolean numberSizeVaildation(List<Integer> numbers){
        for(int num : numbers){
            if(num > 45 && num < 1){
                return true;
            }
        }
        return false;
    }
}
