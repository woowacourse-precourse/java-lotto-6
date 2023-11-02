package lotto.domain;

import java.util.List;

import lotto.util.ErrorMessage;

public class Lotto {
	
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;
	
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
    	validateSize(numbers);
    	validateDuplicateNumber(numbers);
    	validateNumberOutOfRange(numbers);
    }
    
    private void validateSize(List<Integer> numbers) {
    	if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getForMatMessage(LOTTO_SIZE));
        }
    }
    
    private void validateDuplicateNumber(List<Integer> numbers) {
    	if (numbers.stream().distinct().count() != numbers.size()){
    		throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    	}
    }
    
    private void validateNumberOutOfRange(List<Integer> numbers) {
    	if (numbers.stream().anyMatch(this::isNumberOutOfRange)){
    		throw new IllegalArgumentException(
    					ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getForMatMessage(MIN_NUMBER, MAX_NUMBER));
    	}
    }
    
    private boolean isNumberOutOfRange(int number) {
    	return number > MAX_NUMBER || number < MIN_NUMBER;
    }
 
    public int getNumber(int index) {
    	return numbers.get(index);
    }
}
