package lotto.domain;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.MoneyException;
import lotto.validation.NumberValidator;

public class NumberValidatorTest {

	@Test
	void 입력값이_숫자가_아니면_예외를_던진다() {
		String notNumber = "abc";

		assertThatThrownBy(() -> NumberValidator.validateNumber(notNumber))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(INVALID_NUMBER.getMessage());
	}

	@Test
	void 입력값이_양수가_아니면_예외를_던진다() {
		int negativeNumber = -1;
		int zero = 0;

		assertThatThrownBy(() -> NumberValidator.validatePositive(negativeNumber))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(MONEY_POSITIVE_ERROR.getMessage());

		assertThatThrownBy(() -> NumberValidator.validatePositive(zero))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(MONEY_POSITIVE_ERROR.getMessage());
	}
}

