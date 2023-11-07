package lotto.domain;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.validation.NumberValidator;

public class NumberValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "1"})
	void 입력값이_int형인지_확인한다(String input) {
		assertThatCode(() -> NumberValidator.validateIntType(input))
			.doesNotThrowAnyException();
	}

	@Test
	void 입력값이_int형이_아니면_예외를_던진다() {
		String notNumber = "abc";

		assertThatThrownBy(() -> NumberValidator.validateIntType(notNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(INVALID_NUMBER.getMessage());
	}

	@Test
	void 입력값이_양수가_아니면_예외를_던진다() {
		int negativeNumber = -1;
		int zero = 0;

		assertThatThrownBy(() -> NumberValidator.validatePositive(negativeNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(POSITIVE_NUMBER_ERROR.getMessage());

		assertThatThrownBy(() -> NumberValidator.validatePositive(zero))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(POSITIVE_NUMBER_ERROR.getMessage());
	}
}

