package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateLotto {
	
	private final int MIN_LOTTO_NUMBER = 1;
	private final int MAX_LOTTO_NUMBER = 45;
	private final int NUMBER_OF_LOTTO = 6;
	
	public List<Integer> numbers(){
		
		List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO));
		sort(numbers);
		
		return numbers;	
	}
	
	private void sort(List<Integer> numbers) {
		
		Collections.sort(numbers);
	}
}
