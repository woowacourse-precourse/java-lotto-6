package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumberMaker {

	private static final String SEPARATOR = ",";
	private static final int SIZE = 6;
	// 숫자만 허용
	private static final Pattern ONLY_NUMBER = Pattern.compile("^[\\d]*$");
	// 1~45 사이의 숫자만 허용
	private static final Pattern NUMBER_RANGE = Pattern.compile("^[1-9]$|^[0-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$");


	public static List<Integer> make(String inputNumber) {

		validateSeparator(inputNumber);

		List<Integer> winningNumber = Arrays.stream(inputNumber.split(SEPARATOR))
			.map(String::trim)
			.distinct()
			.peek(WinningNumberMaker::validateOnlyNumber)
			.peek(WinningNumberMaker::validateRange)
			.map(Integer::parseInt)
			.toList();

		validateSize(winningNumber);

		return winningNumber;

	}

	private static void validateSeparator(String inputNumber) {
		if (!inputNumber.contains(SEPARATOR)) {
			throw new IllegalArgumentException("구분자(,)만을 이용해 나눠주세요");
		}
	}

	private static void validateOnlyNumber(String inputNumber) {
		if (!isNumber(inputNumber)) {
			throw new IllegalArgumentException("양수의 숫자만 입력해주세요");
		}
	}

	private static boolean isNumber(String inputNumber) {
		return ONLY_NUMBER.matcher(inputNumber).matches();
	}

	private static void validateRange(String inputNumber) {
		if (!inRange(inputNumber)) {
			throw new IllegalArgumentException("1~45 사이의 숫자만 입력해주세요");
		}
	}

	private static boolean inRange(String inputNumber) {
		return NUMBER_RANGE.matcher(inputNumber).matches();
	}

	private static void validateSize(List<Integer> winningNumber) {

		if (winningNumber.size() != SIZE) {
			throw new IllegalArgumentException("중복되지 않는 6개의 숫자만 입력해주세요");
		}
	}

}
