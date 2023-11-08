package lotto.domain.vo;

import lotto.validation.Validator;
import lotto.validation.validators.InvalidMoneyValue;
import lotto.validation.validators.LottoGameValidator;

public record Money(
		int money
) {
	public Money {
		Validator.of(new LottoGameValidator[]{
				new InvalidMoneyValue()
		}).validate(money);
	}
}
