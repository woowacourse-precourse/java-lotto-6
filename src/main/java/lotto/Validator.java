package lotto;

import java.util.regex.Pattern;

public class Validator {
	public void isComposedOfNumbers(String cost) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]+$", cost)) {
			throw new IllegalArgumentException(ErrorCode.NOT_COMPOSED_OF_NUMBERS.getErrorMessage());
		}
	}

	public void isMultiplesOfThousand(Long cost) throws IllegalArgumentException {
		if (cost % 1000 != 0) {
			throw new IllegalArgumentException(ErrorCode.NOT_DIVISIBLE_BY_THOUSAND.getErrorMessage());
		}
	}

	public void isThisSizeSix(String[] numbers) throws IllegalArgumentException {
		if (numbers.length != 6) {
			throw new IllegalArgumentException(ErrorCode.ELEMENTS_SHOULD_BE_SIX.getErrorMessage());
		}
	}

	public void isInRange(String number) throws IllegalArgumentException{
		int checkNumber = Integer.parseInt(number);
		if (!(1 <= checkNumber && checkNumber <= 45)) {
			throw new IllegalArgumentException(ErrorCode.NOT_IN_RANGE.getErrorMessage());
		}
	}
}
