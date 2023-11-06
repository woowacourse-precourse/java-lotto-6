package lotto.controller;

import java.util.List;

import lotto.input.InputMachine;
import lotto.validation.NumbersValidation;

public class MakerController {
	boolean errorSign;

	InputMachine inputMachine = new InputMachine();

	public int makeCorrectPurchaseTime() {

		String inputPurchaseAmount;

		do {
			inputPurchaseAmount = inputMachine.inputPurchaseAmount();
			errorSign = hasPurchaseError(inputPurchaseAmount);

		} while (errorSign);

		return PurchaseTimeMaker.makePurchaseTime(inputPurchaseAmount);
	}

	private boolean hasPurchaseError(String purchaseAmount) {

		try {
			PurchaseTimeMaker.makePurchaseTime(purchaseAmount);
			return false;

		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	public List<Integer> makeCorrectWinningNumber() {

		String inputWinningNumber;

		do {
			inputWinningNumber = inputMachine.inputWinningNumber();
			errorSign = hasWinningNumberError(inputWinningNumber);
		} while (errorSign);

		return WinningNumberMaker.make(inputWinningNumber);
	}

	private boolean hasWinningNumberError(String inputWinningNumber) {

		try {
			NumbersValidation.validateSeparator(inputWinningNumber);
			WinningNumberMaker.make(inputWinningNumber);
			return false;

		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	public int makeCorrectBonusNumber() {

		String inputBonusNumber;

		do {
			inputBonusNumber = inputMachine.inputBonusNumber();
			errorSign = hasBonusNumberError(inputBonusNumber);

		} while (errorSign);

		return WinningNumberMaker.makeBonusNumber(inputBonusNumber);
	}

	private boolean hasBonusNumberError(String inputBonusNumber) {

		try {
			WinningNumberMaker.makeBonusNumber(inputBonusNumber);
			return false;

		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}

	}

}
