package lotto.domain;

import static lotto.validator.AmountValidator.validateAmount;
import static lotto.validator.AmountValidator.validateNumber;

public class PlayerLottoAmount {
	private static final int LOTTO_MIN_AMOUNT = 1000;

	private final int amount;

	public PlayerLottoAmount(String amount) {
		int amountNum = validateNumber(amount);
		validateAmount(amountNum);
		this.amount = amountNum;
	}

	public int calculateLottoCount() {
		return amount / LOTTO_MIN_AMOUNT;
	}

}