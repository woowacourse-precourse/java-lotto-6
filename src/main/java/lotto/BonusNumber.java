//BonusNumber.java
package lotto;

import lotto.Constant.LottoInfo;
import lotto.Enum.ErrorMessage;

public class BonusNumber {
	Integer bonusNumber;

	public BonusNumber(String input, WinningNumbers winningNumbers){
		validate(input, winningNumbers);
		this.bonusNumber = Integer.parseInt(input);
	}

	public boolean checkIsMatch(Lotto lotto){
		return lotto.have(bonusNumber);
	}

	private void validate(String input, WinningNumbers winningNumbers) {
		int number = Integer.parseInt(input);
		validateIsNumber(input);
		validateNumberRange(number);
		validateNotDuplicate(number, winningNumbers);
	}

	//숫자가 아닌 경우
	private void validateIsNumber(String input) {
		if (!input.matches("^[0-9]+$")) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_NUMBER.getMessage());
		}
	}

	//로또의 숫자 범위를 넘어서는 경우
	private void validateNumberRange(int number) {
		if (number < LottoInfo.getMIN_NUMBER() || number > LottoInfo.getMAX_NUMBER()) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
		}
	}

	//winningNumbers와 중복되는 경우
	private void validateNotDuplicate(int number, WinningNumbers winningNumbers) {
		if (winningNumbers.have(number)) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_NUMBER.getMessage());
		}
	}
}
