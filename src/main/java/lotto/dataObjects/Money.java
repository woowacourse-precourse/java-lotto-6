package lotto.dataObjects;

import lotto.enumContainer.ErrorOperation;
import lotto.enumContainer.RelateToLotto;

public class Money {

	private int purchaseMoney;
	private int benefit;

	public Money(int purchaseMoney) {
		validateMinimum(purchaseMoney);
		validateRest(purchaseMoney);
		this.purchaseMoney = purchaseMoney;
	}

	public int calculateAmount() {
		return purchaseMoney/RelateToLotto.MINIMUM_MONEY.number();
	}

	private void validateMinimum(int purchaseMoney) {
		if (purchaseMoney < RelateToLotto.MINIMUM_MONEY.number()) {
			ErrorOperation.MINIMUM_ERROR.apply();
		}
	}

	private void validateRest(int purchaseMoney) {
		if (purchaseMoney % RelateToLotto.MINIMUM_MONEY.number() != 0) {
			ErrorOperation.UNIT_ERROR.apply();
		}
	}

	public void plusBenefit(int benefit) {
		this.benefit += benefit;
		System.out.println("개이덕 "+benefit);
	}
}
