package lotto;
import java.util.List;

public class Error {

	public boolean isInRange(int number) {
		return (Number.MIN_NUMBER.getNumber() <= number && number <= Number.MAX_NUMBER.getNumber());
	}

	public boolean isNegative(int number) {
		return number < Number.ZERO.getNumber();
	}

	private boolean isDigit(char digit) {
		return Character.isDigit(digit);
	}

	public boolean isStringDigit(String number) {
		for (int i = Number.ZERO.getNumber(); i < number.length(); i++) {
			if (!isDigit(number.charAt(i)))
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

	public void checkDigitError(String purchaseMoney) {
		if (!isStringDigit(purchaseMoney))
			throw new IllegalArgumentException();
		int money = Integer.parseInt(purchaseMoney);
		if (isRemainder(money))
			throw new IllegalArgumentException();
		if (isNegative(money))
			throw new IllegalArgumentException();
	}

	public void checkDigitWithDuplicate(List<Integer> winningNumbers, String digit) {
		checkDigitError(digit);
		if (isDuplicate(winningNumbers, Integer.parseInt(digit)))
			throw new IllegalArgumentException();
	}
}
