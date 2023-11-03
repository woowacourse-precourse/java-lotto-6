package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;


	public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkBoundOf(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    
    // 1부터 45이하인 숫자인지 검사하는 메소드
    private void checkBoundOf(List<Integer> numbers) {
    	for (int number : numbers) {
    		if (number < 1 || number > 45) {
    			throw new IllegalStateException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    		}
    	}
    }
    
    // 중복되는 숫자가 있는지 확인하는 메소드
    private void checkDuplicate(List<Integer> numbers) {
    	Set<Integer> newNumbers = new HashSet<>(numbers);
    	if(newNumbers.size() != numbers.size()) {
    		throw new IllegalStateException("[ERROR] 중복되지 않는 서로 다른 숫자 6개를 입력해주세요.");
    	}
    }
    
    
    public List<Integer> getNumbers() {
    	return numbers;
    }
    
}
