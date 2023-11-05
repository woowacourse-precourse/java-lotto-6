package lotto;

public class InputMoney {
	private final Integer money;

	public InputMoney(String userInput) {
		validateInputIsNumber(userInput);
		Integer inputMoney = convertStringToInteger(userInput);
		validateInputUnit(inputMoney);
		this.money = inputMoney;
	}

	private void validateInputUnit(Integer money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(PriceInputError.INVALID_UNIT_INPUT.getErrorDescription());
		}
	}

	private void validateInputIsNumber(String input) {
		if (!Character.isDigit(input.charAt(0))) {
			throw new IllegalArgumentException(PriceInputError.INVALID_TYPE_INPUT.getErrorDescription());
		}
	}

	private Integer convertStringToInteger(String userInput) {
		return Integer.parseInt(userInput);
	}

	public Integer getMoney(){
		return this.money;
	}
}
