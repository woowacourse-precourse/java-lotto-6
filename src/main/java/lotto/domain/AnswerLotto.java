package lotto.domain;

import java.util.List;

import lotto.util.message.ErrorMessage;

public class AnswerLotto extends Lotto {

	private final BonusNumber bonus;

	public AnswerLotto(List<Integer> numbers, int bonusNumber) {
		super(numbers);
		validateBonusNumber(numbers, bonusNumber);
		this.bonus = new BonusNumber(bonusNumber);
	}

	private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
		validateDuplicateBonusNumber(numbers, bonusNumber);
		validateBonusNumberOutOfRange(bonusNumber);
	}

	private void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
		}
	}

	private void validateBonusNumberOutOfRange(int bonusNumber) {
		if (isNumberOutOfRange(bonusNumber)) {
			throw new IllegalArgumentException(
					ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getForMatMessage(MIN_NUMBER, MAX_NUMBER));
		}
	}

	public int getBonusNumber() {
		return bonus.getBonusNumber();
	}
}
