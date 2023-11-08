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
        	System.out.println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(duplicateNumbers(numbers)) {
        	System.out.println("[ERROR] 로또 숫자는 중복되서는 안됩니다.");
        	throw new IllegalArgumentException();
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