package lotto.domain;

public class AnswerLotto {

	private final Lotto answerLottoNumbers;
	private final BonusNumber bonusNumber;

	public AnswerLotto(Lotto lotto, BonusNumber bonusNumber) {
		this.answerLottoNumbers = lotto;
		this.bonusNumber = bonusNumber;
	}	

	public int getAnswerLottoNumbersSize(){
		return answerLottoNumbers.getSize();
	}
	
	public int getBonusNumber() {
		return bonusNumber.getBonusNumber();
	}
	
	public boolean isContain(int number) {
		return answerLottoNumbers.isContain(number);
	}
}
