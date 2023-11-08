package lotto.dataObjects;

import lotto.enumContainer.ErrorOperation;
import lotto.enumContainer.RelateToLotto;

public class Money {

	private int purchaseMoney;
	private int benefit;
	private int lottoCount;

	public Money(int purchaseMoney) {
		validateMinimum(purchaseMoney);
		validateRest(purchaseMoney);
		this.purchaseMoney = purchaseMoney;
	}

	public int calculateAmount() {
		lottoCount = purchaseMoney/RelateToLotto.MINIMUM_MONEY.number();
		return lottoCount;
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
	}

	public double calculateProfitRate() {
		double profitRate = 100 + ((double)(benefit - purchaseMoney) / purchaseMoney * 100);
		return Math.round(profitRate * 100) / 100.0;
	}
}
