package lotto.controller.validation;

import static lotto.domain.MoneyUnit.MONEY_UNIT;
import static lotto.domain.MoneyUnit.WANTED_REMAINDER;

import lotto.domain.MoneyUnit;
import lotto.view.ErrorOutputView;

public class LottoPurchaseMoneyValidator {
	ErrorOutputView errorOutputView = new ErrorOutputView();
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
		Integer scannedPurchaseMoneyUnitDivideRemainder = Integer.parseInt(scannedPurchaseMoneyString) % MONEY_UNIT.getValue();
		if (scannedPurchaseMoneyUnitDivideRemainder != WANTED_REMAINDER.getValue()) {
			errorOutputView.printErrorOfLottoPurchaseMoneyUnit();
			throw new IllegalArgumentException();
		}
	}
}
