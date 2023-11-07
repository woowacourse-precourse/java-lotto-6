package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BuyLottoNumber {

	private static final int LOTTO_NUMBER = 6;
	private List<Integer> numbers;
	
	public BuyLottoNumber() {
		List<Integer> numbers = new ArrayList<Integer>(getRandomNumberList());
		numbers.sort(Comparator.naturalOrder());
		this.numbers = numbers;
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}
	
	private static List<Integer> getRandomNumberList(){
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER);
		validateNotOverlap(numbers);
		return numbers;
	}
	
    private static void validateNotOverlap(List<Integer> numbers) {
    	for(int i = 0; i < numbers.size() - 1; i++) {
    		if(numbers.get(i) == numbers.get(i + 1)) {
    			numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER);
    		}
    	}
	}
}
