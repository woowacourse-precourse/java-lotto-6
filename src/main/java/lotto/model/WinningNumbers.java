package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.validator.Validator;

public class WinningNumbers {
	
	private List<Integer> numbers;
	
	private final Validator validator = new Validator();
	
	public WinningNumbers(List<Integer> numbers) {
		validator(numbers);
		this.numbers = numbers;
	}
	
	public WinningNumbers(String input) {
		List<Integer> winningNumbers = new ArrayList<Integer>();
		for(String numbers : input.split(",")) {
//			valida
			winningNumbers.add(Integer.parseInt(numbers));
		}
		this.numbers = numbers;
	}
	
	public List<Integer> getWinningNumbers(){
		return this.numbers;
	}

	private void validator(List<Integer> numbers) {
		
	}
}
