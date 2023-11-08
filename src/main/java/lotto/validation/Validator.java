package lotto.validation;

import lotto.validation.validators.LottoGameValidator;

public class Validator {
	private final LottoGameValidator[] lottoValidators;

	private Validator(LottoGameValidator[] lottoValidators) {
		this.lottoValidators = lottoValidators;
	}

	public static Validator of(LottoGameValidator[] lottoValidators) {
		return new Validator(lottoValidators);
	}

	public void validate(Object value) {
		for (LottoGameValidator validator : lottoValidators) {
			validator.validate(value);
		}
	}
}
