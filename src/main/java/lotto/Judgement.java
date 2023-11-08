package lotto;

import java.util.List;

public class Judgement {
	public boolean isInRange(int number) {
		return (Number.MIN_NUMBER.getNumber() <= number && number <= Number.MAX_NUMBER.getNumber());
	}

	public boolean isNegative(int number) {
		return number < Number.ZERO.getNumber();
	}

	public boolean isStringDigit(String number) {
		for (int i = Number.ZERO.getNumber(); i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i)))
				return false;
		}
		return true;
	}

	public boolean isRemainder(int number) {
		int remainder = number % Number.LOTTO_PRICE.getNumber();
		return remainder == Number.ZERO.getNumber();
	}

	public boolean isDuplicate(List<Integer> numbers, int number) {
		return numbers.contains(number);
	}

	public boolean isEmpty(String line) {
		return line.isEmpty();
	}
}
