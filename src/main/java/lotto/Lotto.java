package lotto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
    	sizeValidate(numbers);
    	distinctValidate(numbers);
    	rangeValidate(numbers);
        this.numbers = numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void distinctValidate(List<Integer> numbers) {
    	Set<Integer> deleteDuplicate = new HashSet<Integer>(numbers);
    	if (numbers.size() != deleteDuplicate.size()) {
    		throw new IllegalArgumentException();
		}
    }
    
    private void rangeValidate(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (number < 1 || number > 45) {
				throw new IllegalArgumentException();
			}
		}
	}
}
