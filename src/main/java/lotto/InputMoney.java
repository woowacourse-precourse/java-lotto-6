package lotto;

import lotto.enums.PriceInputError;

public class InputMoney {
	private final Integer money;

	public InputMoney(Integer userInput) {
		validateInputUnit(userInput);
		this.money = userInput;
	}

	private void validateInputUnit(Integer money) {
		if (money == 0 || money % 1000 != 0) {
			throw new IllegalArgumentException(PriceInputError.INVALID_UNIT_INPUT.getErrorDescription());
		}
	}

	public Integer getMoney() {
		return this.money;
	}
}
