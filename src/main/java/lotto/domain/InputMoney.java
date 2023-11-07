package lotto.domain;

public class InputMoney {
	private final int inputMoney;
	private MoneyValidator moneyValidator;

	public InputMoney(MoneyValidator moneyValidator, String input) {
		this.moneyValidator = moneyValidator;
		this.inputMoney = validateMoney(input);
	}

	public int getInputMoney() {
		return this.inputMoney;
	}

	private int validateMoney(String input) {
		moneyValidator.validateNumber(input);
		int inputMoney = Integer.parseInt(input);
		return inputMoney;
	}
}
