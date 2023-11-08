package lotto.domain;

import java.util.List;

import lotto.validation.Validation;

public class Lotto {
	
	public static final int SIZE = 6;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
    	validate(numbers);
        this.numbers = numbers;
    }
    
    public List<Integer> getNumbers() {
    	return numbers;
    }
    
	public static void validate (List<Integer> numbers) {
		Validation.validateListSize(numbers, SIZE);
		Validation.validateDistinctedNumbers(numbers);
		Validation.validateListNumbersInRange(numbers, MIN_NUMBER, MAX_NUMBER);
    }
}
