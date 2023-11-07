package lotto.model;

import java.util.List;

import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    public List<Integer> getnumbers(){
    	return numbers;
    }

    private void validate(List<Integer> numbers) {
    	Validator validator = new Validator();
        validator.LottoSizeFormat(numbers);
        validator.DuplicatedNumber(numbers);
    }

    public int match(Lotto winningNumber) {
    	return (int) numbers.stream()
    			.filter(winningNumber::containNumber)
    			.count();
    }
    
    public boolean containNumber(int number) {
    	return numbers.contains(number);
    }
}
