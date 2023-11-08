package lotto.domain;

import static lotto.constant.CashConstant.INIT_SPEND_AMOUNT;
import static lotto.constant.CashConstant.UNIT;
import static lotto.exception.CashExceptionMessage.NOT_MORE_THAN_UNIT;
import static lotto.exception.CashExceptionMessage.WRONG_INIT_AMOUNT;
import static lotto.exception.CashExceptionMessage.NOT_DIVISIBLE_BY_UNIT;

public class Cash {

	private final Integer depositAmount;
	private Integer spendAmount;

	private Cash(final Integer depositAmount,
		final Integer spendAmount) {
		validateMoreThanUnit(depositAmount);
		validateDivisibleByUnit(depositAmount);
		validateInitSpendAmount(spendAmount);
		this.depositAmount = depositAmount;
		this.spendAmount = spendAmount;
	}

	public static Cash create(final Integer depositAmount,
		final Integer spendAmount) {
		return new Cash(depositAmount, spendAmount);
	}

	private void validateMoreThanUnit(final Integer depositAmount) {
		if (depositAmount < UNIT.getSetting()) {
			throw new IllegalArgumentException(NOT_MORE_THAN_UNIT.getMessage());
		}
	}

	private void validateInitSpendAmount(final Integer spendAmount) {
		if (spendAmount != INIT_SPEND_AMOUNT.getSetting()) {
			throw new IllegalStateException(WRONG_INIT_AMOUNT.getMessage());
		}
	}


	private void validateDivisibleByUnit(final Integer amount) {
		final int remainder = amount % UNIT.getSetting();
		if (remainder != INIT_SPEND_AMOUNT.getSetting()) {
			throw new IllegalArgumentException(NOT_DIVISIBLE_BY_UNIT.getMessage());
		}
	}


	public Boolean isAfford() {
		final int leftAmount = depositAmount - spendAmount;
		return leftAmount >= UNIT.getSetting();
	}

	public Boolean spendOneUnit() {
		final Boolean afford = isAfford();
		if (afford) {
			spendAmount += UNIT.getSetting();
		}

		return afford;
	}

	public Integer getDepositAmount() {
		return depositAmount;
	}

}
