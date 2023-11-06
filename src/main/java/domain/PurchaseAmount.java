package domain;

public class PurchaseAmount {
	private final int amount;

	public PurchaseAmount(String amount) {
		validateIsDigit(amount);
		int convertedAmount = convertStringToInt(amount);
		validateIsPositive(convertedAmount);
		validateIsThousandUnit(convertedAmount);
		this.amount = convertedAmount;
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

	private void validateIsThousandUnit(int amount) {
		if (!(amount % 1000 == 0)) {
			throw new IllegalArgumentException("[ERROR] 입력 단위는 1000단위 입니다");
		}
	}

	private boolean isDigit(String amount) {
		return amount.chars()
				.allMatch(Character::isDigit);
	}

	private void validateIsPositive(int amount) {
		if (!(amount > 0)) {
			throw new IllegalArgumentException("[ERROR] 0을 초과한 금액을 입력을 입력하세요");
		}
	}

}
