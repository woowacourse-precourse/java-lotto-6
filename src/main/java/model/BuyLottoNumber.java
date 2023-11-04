package model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BuyLottoNumber {

	private static final int LOTTO_NUMBER = 6;
	private List<Integer> numbers;
	
	public BuyLottoNumber() {
		this.numbers = getRandomNumberList();
	}
	
	private static List<Integer> getRandomNumberList(){
		List<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < LOTTO_NUMBER; i++) {
			int number = Randoms.pickNumberInRange(1, 45);
			numbers.add(number);
		}
		validateNotOverlap(numbers);
		return numbers;
	}
	
    private static void validateNotOverlap(List<Integer> numbers) {
    	for(int i = 0; i < numbers.size() - 1; i++) {
    		if(numbers.get(i) == numbers.get(i + 1)) {
    			int randomNumber = Randoms.pickNumberInRange(1, 45);
    			numbers.set(i + 1, randomNumber);
    			validateNotOverlap(numbers);
    		}
    	}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
