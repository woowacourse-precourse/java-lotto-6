package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int number;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
    
    public Bonus(int number) {
    	validate(number);
    	checkInt(number);
    	this.number = number;
    }
    
    private void validate(int number) {
    	if (number.size() != 1) {
    		throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.")
    	}
    }
    
    private void checkInt(int number) {
    	if (number.getClass().getName() != Integer) {
    		throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
    	}
    }
}
