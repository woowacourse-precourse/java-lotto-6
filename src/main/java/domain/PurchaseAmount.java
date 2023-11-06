package domain;

public class PurchaseAmount {
	private final int amount;

	public PurchaseAmount(String amount) {
		validateIsDigit(amount);
		this.amount = convertStringToInt(amount);
	}

	public int getAmount() {
		return amount;
	}

	private int convertStringToInt(String amount) {
		return Integer.parseInt(amount);
	}

	private void validateIsDigit(String amount) {
		if (!isDigit(amount)) {
			throw new IllegalArgumentException("[ERROR] 금액을 숫자로만 다시 입력해주세요");
		}
	}

	private boolean isDigit(String amount) {
		return amount.chars()
				.allMatch(Character::isDigit);
	}
}
