package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
//        validate(numbers);
        this.numbers = numbers;
    }
    
    public List<Integer> getnumbers(){
    	return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
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
