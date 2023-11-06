package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
    	
    	if(!isSixDigit(numbers))
    		throw new IllegalArgumentException();
    	if(!isNumbersRange1to45(numbers))
    		throw new IllegalArgumentException();
    	if(!isDuplication(numbers))
    		throw new IllegalArgumentException();
    }
    
    private boolean isSixDigit(List<Integer> numbers) {
    	return numbers.size() == 6;
    }
    
    private boolean isNumbersRange1to45(List<Integer> numbers) {
    	
    	for(int number : numbers) {
    		if(number<1 || number >45)
    			return false;
    	}
    	return true;
    }
    
    private boolean isDuplication(List<Integer> numbers) {
    	return sizeSet(numbers) == numbers.size();
    }
    
    private int sizeSet(List<Integer> numbers) {
    	Set <Integer> set = new HashSet<Integer>(numbers);
    	return set.size();
    }
}
