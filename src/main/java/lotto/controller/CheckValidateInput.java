package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckValidateInput {

	public int money(String money) {

		if (!isInteger(money))
			throw new IllegalArgumentException();
		if (!isUnits1000(Integer.parseInt(money)))
			throw new IllegalArgumentException();
		if (!inRangeMoney(Integer.parseInt(money)))
			throw new IllegalArgumentException();

		return Integer.parseInt(money);
	}

	private boolean isUnits1000(int money) {
		return (money % 1000) == 0;
	}

	private boolean inRangeMoney(int money) {
		return (money > 0) && (money < Integer.MAX_VALUE);
	}

	public int bonusNumber(String bonusNumber, List<Integer> lotto) {

		if (!isInteger(bonusNumber))
			throw new IllegalArgumentException();
		if (!inRangeBonusNumber(Integer.parseInt(bonusNumber)))
			throw new IllegalArgumentException();
		if (numberInLotto(Integer.parseInt(bonusNumber), lotto))
			throw new IllegalArgumentException();

		return Integer.parseInt(bonusNumber);
	}

	private boolean numberInLotto(int bonusNumber, List<Integer> lotto) {
		return lotto.contains(bonusNumber);
	}

	private boolean inRangeBonusNumber(int bonusNumber) {
		return (bonusNumber > 0) && (bonusNumber <= 45);
	}

	public List<Integer> winningNumber(String numbers){
		
		if(isNumbersInteger(separated(numbers)))
			throw new IllegalArgumentException();
		
		List<Integer> winnings = Arrays.stream(separated(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
		
		return winnings;
	}
	
	private String[] separated(String numbers) {
		return numbers.split(",");
	}
	
	private boolean isNumbersInteger(String[] numbers) {
		for(String number : numbers) {
			if(!isInteger(number))
				return false;
		}
		return true;
	}
	
	private boolean isInteger(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
