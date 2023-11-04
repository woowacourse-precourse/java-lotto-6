package lotto.domain;

import java.util.List;

import lotto.validation.WinningValidation;

public class Winning {
	private final List<Integer> numbers;
	
	public Winning(List<Integer> numbers) {
		winningValidation(numbers);
		this.numbers = numbers;
	}
	
	private void winningValidation(List<Integer> numbers) {
		WinningValidation.isWinningCorrect(numbers);
	}
	
	public void setBonus(int bonus) {
		bonusValidation(bonus);
		this.numbers.add(bonus);
	}
	
	private void bonusValidation(int bonus) {
		WinningValidation.isBonusCorrect(bonus, numbers);
	}
	public List<Integer> checkLotto() {
		return null;
	}
}