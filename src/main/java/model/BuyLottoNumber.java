package model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import camp.nextstep.edu.missionutils.Randoms;

public class BuyLottoNumber {

	private static final int LOTTO_NUMBER = 6;
	private List<Integer> numbers;
	
	public BuyLottoNumber() {
		this.numbers = getRandomNumberList();
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}
	
	private static List<Integer> getRandomNumberList(){
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER);
		TreeSet<Integer> numberSet = new TreeSet<>(numbers);
		validateNotOverlap(numberSet);
		numbers = new ArrayList<Integer>(numberSet);
		return numbers;
	}
	
    private static void validateNotOverlap(TreeSet<Integer> numberSet) {
    	while(true) {
    		if(numberSet.size() == LOTTO_NUMBER) {
    			break;
    		}
    		numberSet = new TreeSet<>(Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER));
    	}
	}
}
