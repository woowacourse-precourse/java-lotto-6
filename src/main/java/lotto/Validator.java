package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
	public void checkComposedOfNumbers(String check) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]+$", check)) {
			throw new IllegalArgumentException(ErrorCode.NOT_COMPOSED_OF_NUMBERS.getErrorMessage());
		}
	}

	public void checkMultiplesOfThousand(Long cost) throws IllegalArgumentException {
		if (cost % 1000 != 0) {
			throw new IllegalArgumentException(ErrorCode.NOT_DIVISIBLE_BY_THOUSAND.getErrorMessage());
		}
	}

	public void checkInRange(String number) throws IllegalArgumentException {
		int checkNumber = Integer.parseInt(number);
		if (!(1 <= checkNumber && checkNumber <= 45)) {
			throw new IllegalArgumentException(ErrorCode.NOT_IN_RANGE.getErrorMessage());
		}
	}

	public void checkContainNumber(List<Integer> userNumbers, String inputBonusNumber) throws IllegalArgumentException {
		int checkNumber = Integer.parseInt(inputBonusNumber);
		if (userNumbers.contains(checkNumber)) {
			throw new IllegalArgumentException(ErrorCode.NOT_ALLOW_DUPLICATE.getErrorMessage());
		}
	}
}
