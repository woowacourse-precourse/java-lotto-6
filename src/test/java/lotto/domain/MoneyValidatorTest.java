package lotto.domain;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@Test
	void 입력금액이_양수가_아니면_예외를_던진다() {
		int negativeNumber = -1;
		int zero = 0;

		assertThatThrownBy(() -> moneyValidator.validatePositive(negativeNumber))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(MONEY_POSITIVE_ERROR.getMessage());

		assertThatThrownBy(() -> moneyValidator.validatePositive(zero))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(MONEY_POSITIVE_ERROR.getMessage());
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 900, 1_001, 100_001})
	void 입력금액이_기준단위로_나눠지지않으면_예외를_던진다(int input) {
		assertThatThrownBy(() -> moneyValidator.validateUnit(input))
			.isExactlyInstanceOf(MoneyException.class)
			.hasMessage(MONEY_UNIT_ERROR.getMessage());
	}
}

