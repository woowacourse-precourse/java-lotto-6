package lotto.domain;

public class AnswerLotto {

	private final Lotto answerLottoNumbers;
	private final BonusNumber bonusNumber;

	public AnswerLotto(Lotto answerLottoNumbers, BonusNumber bonusNumber) {
		this.answerLottoNumbers = answerLottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	public int getAnswerLottoNumbersSize() {
		return answerLottoNumbers.getSize();
	}

	public int getBonusNumber() {
		return bonusNumber.getBonusNumber();
	}

	public boolean isContain(int number) {
		return answerLottoNumbers.isContain(number);
	}
}