package domain;

import java.util.List;

import view.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
        	ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }
    

    public List<Integer> getLottoNumbers(){
    	return numbers;
    }
}

