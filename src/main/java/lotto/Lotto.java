package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
        if(duplicateNumbers(numbers)) {
        	throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복되서는 안됩니다.");
        }
    }
    
    private boolean duplicateNumbers(List<Integer> numbers) {
    	for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public List<Integer> getNumbers(){
    	return numbers;
    }
}