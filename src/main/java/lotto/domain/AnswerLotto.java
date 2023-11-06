package lotto.domain;

import java.util.List;

import lotto.util.message.ErrorMessage;

public class AnswerLotto extends Lotto {

	private final BonusNumber bonusNumber;

	public AnswerLotto(List<Integer> numbers, int number) {
		super(numbers);
		validateBonusNumber(numbers, number);
		this.bonusNumber = new BonusNumber(number);
	}

	private void validateBonusNumber(List<Integer> numbers, int number) {
		validateDuplicateBonusNumber(numbers, number);
		validateBonusNumberOutOfRange(number);
	}

	private void validateDuplicateBonusNumber(List<Integer> numbers, int number) {
		if (numbers.contains(number)) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
		}
	}

	private void validateBonusNumberOutOfRange(int number) {
		if (isNumberOutOfRange(number)) {
			throw new IllegalArgumentException(
					ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getFormattedMessage(MIN_NUMBER, MAX_NUMBER));
		}
	}
	
	public int getAnswerLottoNumbersSize(){
		return this.getSize();
	}
	
	public int getBonusNumber() {
		return bonusNumber.bonusNumber();
	}
}
