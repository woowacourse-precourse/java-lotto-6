package lotto;

public class InputMoney {
	private final Integer money;

	public InputMoney(String userInput) {
		validateInputIsNumber(userInput);
		Integer inputMoney = convertStringToInteger(userInput);
		validate(inputMoney);
		this.money = inputMoney;
	}

	private void validate(Integer money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 급액을 천원 단위로 입력해 주세요.");
		}
	}

	private void validateInputIsNumber(String input) {
		if (!Character.isDigit(input.charAt(0))) {
			throw new IllegalArgumentException("[ERROR] 금액으로 숫자를 입력해 주세요.");
		}
	}

	private Integer convertStringToInteger(String userInput) {
		return Integer.parseInt(userInput);
	}

	public Integer getMoney(){
		return this.money;
	}
}
