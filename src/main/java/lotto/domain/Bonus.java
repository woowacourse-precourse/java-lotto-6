package lotto.domain;

import lotto.validation.LottoValidator;
import lotto.validation.NumberValidator;

public class Bonus {
	private int bonus;

	public Bonus(String input) {
		this.bonus = validateBonus(input);
	}

	private int validateBonus(String input) {
		NumberValidator.validateIntType(input);
		int inputBonus = Integer.parseInt(input);

		LottoValidator.validateRange(inputBonus);
		return inputBonus;
	}

	public boolean compareWith(Lotto lotto) {
		return lotto.getLotto().contains(bonus);
	}
}
