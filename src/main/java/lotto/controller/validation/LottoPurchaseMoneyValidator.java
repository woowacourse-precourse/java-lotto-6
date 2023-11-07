package lotto.controller.validation;

import lotto.view.ErrorOutputView;

public class LottoPurchaseMoneyValidator {
	ErrorOutputView errorOutputView = new ErrorOutputView();
	private static final Integer MONEY_UNIT = 1000;
	private static final Integer WANTED_REMAINDER = 0;
	public void checkValidatioOfLottoPurchaseMoney(String scannedPurchaseMoneyString) {
		checkLottoPurchaseMoneyWithChar(scannedPurchaseMoneyString);
	}

	private void checkLottoPurchaseMoneyWithChar(String scannedPurchaseMoneyString) {
		try{
			Integer.parseInt(scannedPurchaseMoneyString);
		}
		catch(Exception exception){
			errorOutputView.printErrorOfLottoPurchaseMoneyWithChar();
			throw new IllegalArgumentException();
		}
		checkLottoPurchaseMoneyUnit(scannedPurchaseMoneyString);
	}

	private void checkLottoPurchaseMoneyUnit(String scannedPurchaseMoneyString) {
		Integer remainder = Integer.parseInt(scannedPurchaseMoneyString) % MONEY_UNIT;
		if (remainder == WANTED_REMAINDER) {
			errorOutputView.printErrorOfLottoPurchaseMoneyUnit();
			throw new IllegalArgumentException();
		}
	}
}
