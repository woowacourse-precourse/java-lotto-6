package lotto.validation;

import java.util.List;

import lotto.constant.NumbersOption;

public class NumbersValidation {

	public static void validateOnlyNumber(String inputNumber) {

		if (!isNumber(inputNumber)) {
			throw new IllegalArgumentException("양수의 숫자만 입력해주세요");
		}
	}

	private static boolean isNumber(String inputNumber) {
		return NumbersOption.ONLY_NUMBER.matcher(inputNumber).matches();
	}

	public static void validateRange(String inputNumber) {

		if (!inRange(inputNumber)) {
			throw new IllegalArgumentException("1~45 사이의 숫자만 입력해주세요");
		}
	}

	private static boolean inRange(String inputNumber) {
		return NumbersOption.NUMBER_RANGE.matcher(inputNumber).matches();
	}

	public static void validateSize(List<Integer> winningNumber) {

		if (winningNumber.size() != NumbersOption.SIZE) {
			throw new IllegalArgumentException("중복되지 않는 6개의 숫자만 입력해주세요");
		}
	}

}
