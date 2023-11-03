package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_PURCHASE_AMOUNT;
import static lotto.config.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.config.ErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT;
import static lotto.config.LottoConfig.LOTTO_PRICE;

import lotto.util.NumberUtil;

public class PurchaseAmount {

	private final int amount;

	public PurchaseAmount(String amount) {
		validate(amount);
		this.amount = Integer.parseInt(amount);
	}

	private void validate(String amount) {
		if (isBlankOrNull(amount)) {
			throw new IllegalArgumentException(BLANK_PURCHASE_AMOUNT.getMessage());
		}

		if (!NumberUtil.isNumeric(amount)) {
			throw new IllegalArgumentException(NON_NUMERIC_PURCHASE_AMOUNT.getMessage());
		}

		if (!isMultipleOfThousand(amount)) {
			throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
		}
	}

	private boolean isBlankOrNull(String amount) {
		return amount == null || amount.isBlank();
	}

	private boolean isMultipleOfThousand(String amount) {
		return Integer.parseInt(amount) % LOTTO_PRICE.getValue() == 0;
	}
}