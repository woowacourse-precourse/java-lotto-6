package lotto.validation;

import java.util.List;

import lotto.constant.NumbersOption;
import lotto.output.ErrorPrinter;

public class NumbersValidation {

	public static void validateOnlyNumber(String inputNumber) {

		if (!isNumber(inputNumber)) {
			ErrorPrinter.printOnlyNumberError();
			throw new IllegalArgumentException();
		}
	}

	private static boolean isNumber(String inputNumber) {
		return NumbersOption.ONLY_NUMBER.matcher(inputNumber).matches();
	}

	public static void validateRange(String inputNumber) {

		if (!inRange(inputNumber)) {
			ErrorPrinter.printOutOfRange();
			throw new IllegalArgumentException();
		}
	}

	private static boolean inRange(String inputNumber) {
		return NumbersOption.NUMBER_RANGE.matcher(inputNumber).matches();
	}

	public static void validateSize(List<Integer> winningNumber) {

		if (winningNumber.size() != NumbersOption.SIZE) {
			ErrorPrinter.printOutOfSize();
			throw new IllegalArgumentException();
		}
	}

	public static void validateSeparator(String inputNumber) {

		if (!inputNumber.contains(NumbersOption.SEPARATOR)) {
			ErrorPrinter.printSeparatorError();
			throw new IllegalArgumentException();
		}
	}

}
