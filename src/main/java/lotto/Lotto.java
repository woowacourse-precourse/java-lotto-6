package lotto;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void validatNumber(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			isDigit(Integer.toString(numbers.get(i)));
			validateRange(numbers.get(i));
		}

		if (numbers.size() != numbers.stream().distinct().count())
			throw new IllegalArgumentException(Constants.NUMBER_ERROR_MSG);
	}
	
	public static void validateInput(String str) {
		if (str.isEmpty() == true)
			throw new IllegalArgumentException(Constants.EMPTY_ERROR_MSG);
	}

	public static void isDigit(String c) {
		String tmp = "^[0-9]*$";
		if (Pattern.matches(tmp, c) != true)
			throw new IllegalArgumentException(Constants.AMOUNT_ERROR_MSG);
	}

	public static void validateRange(int tmp) {
		if (tmp < 1 || tmp > 45)
			throw new IllegalArgumentException(Constants.RANGE_ERROR_MSG);
	}

	public int matchNumber(List<Integer> inputNum) {
		int count = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.contains(inputNum.get(i)) == true)
				count++;
		}

		return count;
	}
	
	public boolean isBonus(int b) {
		if(numbers.contains(b) == true)
			return true;
		
		return false;
	}

}
