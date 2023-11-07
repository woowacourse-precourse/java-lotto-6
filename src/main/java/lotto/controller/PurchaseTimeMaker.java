package lotto.controller;

import lotto.output.ErrorPrinter;
import lotto.validation.NumbersValidation;

public class PurchaseTimeMaker {

	private static final int LOTTO_PRICE = 1000;

	public static int makePurchaseTime(String inputPurchaseAmount) {

		int purchaseAmount = toIntPurchaseAmount(inputPurchaseAmount);
		validatePurchaseUnit(purchaseAmount);

		return purchaseAmount / LOTTO_PRICE;
	}

	private static int toIntPurchaseAmount(String inputPurchaseAmount) {
		NumbersValidation.validateOnlyNumber(inputPurchaseAmount);
		return Integer.parseInt(inputPurchaseAmount);
	}

	private static void validatePurchaseUnit(int purchaseAmount) {

		if (purchaseAmount % LOTTO_PRICE != 0 || purchaseAmount == 0) {
			ErrorPrinter.printPurchaseUnitError();
			throw new IllegalArgumentException();
		}
	}

}
