package lotto.domain;

import java.util.List;

import lotto.validation.Validation;

public class LottoGame {
	
	private static List<Integer> winningNumbers;
	private int bonusNumber;
	
	public LottoGame(List<Integer> winningNumbers) {
		validateLottoFormat(winningNumbers);
		LottoGame.winningNumbers = winningNumbers;
	}
	
	public List<Integer> getWinningNumbers(){
		return winningNumbers;
	}
	
	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
	
	public void validateLottoFormat(List<Integer> winningNumbers) {
		new Lotto(winningNumbers);
	}

	public static int validateBonusNumber(String input) {
		int bonusNumber;
		Validation.validateNaturalNumber(input);
		bonusNumber = Integer.valueOf(input);
		Validation.validateNumberInRange(bonusNumber, Lotto.MIN_NUMBER, Lotto.MAX_NUMBER);
		Validation.validateNumberNotInList(winningNumbers, bonusNumber);
		return bonusNumber;
	}
	
}
