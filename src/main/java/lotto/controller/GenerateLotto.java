package lotto.controller;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateLotto {
	
	public List<Integer> numbers(){
		
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		sort(numbers);
		
		return numbers;	
	}
	
	private void sort(List<Integer> numbers) {
		Collections.sort(numbers);
	}
	
}
