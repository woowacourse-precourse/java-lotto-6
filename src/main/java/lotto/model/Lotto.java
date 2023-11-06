package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

	public List<Integer> getNumbers() {
		return numbers;
	}

    // TODO: 추가 기능 구현
	
    private void validateUniqueNumbers(List<Integer> numbers) {
    	Set<Integer> uniqueNumbers = new HashSet<>();
    	for(int number : numbers) uniqueNumbers.add(number);
    	if(uniqueNumbers.size()<6) throw new IllegalArgumentException("[ERROR] 6개의 숫자중에서 중복이 있습니다.");
    }
}
