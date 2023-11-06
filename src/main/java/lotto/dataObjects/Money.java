package lotto.dataObjects;

import lotto.enumContainer.ErrorOperation;

public class Money {

	private int purchaseMoney;

	public Money(int purchaseMoney) {
		validateMinimum(purchaseMoney);
		validateRest(purchaseMoney);
		this.purchaseMoney = purchaseMoney;
	}

	private void validateMinimum(int parsePrice) {
		if (parsePrice < 1000) {
			ErrorOperation.MINIMUM_ERROR.apply();
		}
	}

	private void validateRest(int parsePrice) {
		if (parsePrice % 1000 != 0) {
			ErrorOperation.UNIT_ERROR.apply();
		}
	}


}
