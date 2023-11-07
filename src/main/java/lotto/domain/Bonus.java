package lotto.domain;

import java.util.List;

import lotto.validation.LottoValidator;
import lotto.validation.NumberValidator;

public class Bonus {
	private final int bonus;

	public Bonus(String input) {
		this.bonus = validateAndConvertToInt(input);
	}

	private int validateAndConvertToInt(String input) {
		NumberValidator.validateIntType(input);
		LottoValidator.validateRange(Integer.parseInt(input));
		return Integer.parseInt(input);
	}

	public boolean compareWith(List<Integer> lotto) {
		return lotto.contains(bonus);
	}
}
