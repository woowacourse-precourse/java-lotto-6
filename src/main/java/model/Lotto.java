package model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNotOverlap(numbers);
        this.numbers = numbers;
    }

	private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
	
	// TODO: 추가 기능 구현
    private void validateNotOverlap(List<Integer> numbers) {
    	for(int i = 0; i < numbers.size() - 1; i++) {
    		if(numbers.get(i) == numbers.get(i + 1)) {
    			int randomNumber = Randoms.pickNumberInRange(0, 45);
    			numbers.set(i + 1, randomNumber);
    			validateNotOverlap(numbers);
    		}
    	}
	}

	public static List<Integer> getRandomNumberList(int buyLotto){
		List<Integer> randomList = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			int randomNumber = Randoms.pickNumberInRange(0, 45);
			randomList.add(randomNumber);
		}
    	return randomList;
    }
}
