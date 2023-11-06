package lotto;

import java.util.List;

public class Lotto {
	
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
    	correctlySixElements(numbers);
    	validateEachElement(numbers);
    }

    private void correctlySixElements(List<Integer> numbers) {
    	if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호만 유효합니다");
        }
    }
    
    private void validateEachElement(List<Integer> numbers) {
    	for(int num:numbers) {
    		checkDuplicatedElements(num,numbers);
    		valueOutOfBoundary(num);
    	}
    }
    
    private void checkDuplicatedElements(int num,List<Integer> numbers) {
    	if(numbers.indexOf(num)!=numbers.lastIndexOf(num)) {
    		throw new IllegalArgumentException("[ERROR] 중복된 번호는 유효하지 않습니다");
    	}
    }
    
    public void valueOutOfBoundary(int num) {
    	if(num<1||num>45) {
    		throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    	}
    }
}
