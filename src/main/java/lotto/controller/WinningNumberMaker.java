package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.constant.NumbersOption;
import lotto.output.ErrorPrinter;
import lotto.validation.NumbersValidation;

public class WinningNumberMaker {

	private static List<Integer> winningNumber;

	public static List<Integer> make(String inputNumber) {
		winningNumber = new ArrayList<>();

		winningNumber = Arrays.stream(inputNumber.split(NumbersOption.SEPARATOR))
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

		int bonusNumber = Integer.parseInt(inputBonusNumber);

		validateDuplicationBonusNumber(bonusNumber);

		return bonusNumber;
	}

	private static void validateDuplicationBonusNumber(int bonusNumber) {
		if(winningNumber.contains(bonusNumber)) {
			ErrorPrinter.printBonusNumberError();
			throw new IllegalArgumentException();
		}
	}

}
