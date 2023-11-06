package lotto.domain;

import java.util.Arrays;
import java.util.List;

import lotto.validation.NumbersValidation;

public class WinningNumberMaker {

	private static final String SEPARATOR = ",";

	public static List<Integer> make(String inputNumber) {

		List<Integer> winningNumber = Arrays.stream(inputNumber.split(SEPARATOR))
			.map(String::trim)
			.distinct()
			.peek(NumbersValidation::validateOnlyNumber)
			.peek(NumbersValidation::validateRange)
			.map(Integer::parseInt)
			.toList();

		NumbersValidation.validateSize(winningNumber);

		return winningNumber;

	}

	public static int makeBonusNumber(String inputBonusNumber) {
		return Integer.parseInt(inputBonusNumber);
	}



}
