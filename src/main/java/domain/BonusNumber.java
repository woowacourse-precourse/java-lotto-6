package domain;

public class BonusNumber {
	private final int bonusNumber;

	public BonusNumber(String bonusNumber, Lotto lotto) {
		validateIsDigit(bonusNumber);
		int convertedBonusNumber = convertStringToInt(bonusNumber);
		validateIsBetweenLottoRange(convertedBonusNumber);
		validateWinningLottoNumberDuplicate(convertedBonusNumber, lotto);
		this.bonusNumber = convertedBonusNumber;
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

	private void validateIsBetweenLottoRange(int bonusNumber) {
		if (!(1 <= bonusNumber && bonusNumber <= 45)) {
			throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요");
		}
	}

	private boolean isDigit(String bonusNumber) {
		return bonusNumber.chars()
				.allMatch(Character::isDigit);
	}

	private void validateWinningLottoNumberDuplicate(int bonusNumber, Lotto lotto) {
		if (isWinningLottoNumberDuplicate(bonusNumber, lotto)) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호에 없는 번호를 입력해주세요");
		}
	}

	private boolean isWinningLottoNumberDuplicate(int bonusNumber, Lotto lotto) {
		return lotto.getNumbers()
				.stream()
				.noneMatch(number -> number == bonusNumber);
	}

}

