package lotto.model.lotto;

import java.util.List;
import lotto.controller.validation.lotto.LottoNumberValueValidator;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		new LottoNumberValueValidator().checkValidationOfLottoNumber(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
