package lotto.domain;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.exception.MoneyException;

public class MoneyValidatorTest {
	private MoneyValidator moneyValidator = new MoneyValidator();

	@Test
	void 입력금액이_숫자가_아니면_예외를_던진다() {
		String notNumber = "abc";

		assertThatThrownBy(() -> moneyValidator.validateNumber(notNumber))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(INVALID_NUMBER.getMessage());
	}
}

