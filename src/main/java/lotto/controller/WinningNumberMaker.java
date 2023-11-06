package lotto.controller;

import java.util.Arrays;
import java.util.List;

import lotto.constant.NumbersOption;
import lotto.validation.NumbersValidation;

public class WinningNumberMaker {

	public static List<Integer> make(String inputNumber) {

		List<Integer> winningNumber = Arrays.stream(inputNumber.split(NumbersOption.SEPARATOR))
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

		NumbersValidation.validateOnlyNumber(inputBonusNumber);
		NumbersValidation.validateRange(inputBonusNumber);

		return Integer.parseInt(inputBonusNumber);
	}

}
