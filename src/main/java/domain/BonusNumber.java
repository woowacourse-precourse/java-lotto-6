package domain;

public class BonusNumber {
	private final int bonusNumber;

	public BonusNumber(String bonusNumber) {
		validateIsDigit(bonusNumber);
		this.bonusNumber = convertStringToInt(bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private int convertStringToInt(String bonusNumber) {
		return Integer.parseInt(bonusNumber);
	}

	private void validateIsDigit(String bonusNumber) {
		if (!isDigit(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요");
		}
	}

	private boolean isDigit(String bonusNumber) {
		return bonusNumber.chars()
				.allMatch(Character::isDigit);
	}

}

