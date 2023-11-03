package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
	final static int LOTTOLENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTOLENGTH) {
            throw new IllegalArgumentException();
        }
    }
    
    public List<Integer> getNumbers() {
    	return Collections.unmodifiableList(numbers);
    }
}
