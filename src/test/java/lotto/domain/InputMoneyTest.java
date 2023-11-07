package lotto.domain;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputMoneyTest {
	@Test
	void 입력값을_검증하고_객체를_생성한다() {
		String input = "1000";
		InputMoney inputMoney = new InputMoney(input);

		assertThat(inputMoney.getInputMoney()).isEqualTo(Integer.parseInt(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 900, 1_001, 100_001})
	void 입력금액이_기준단위로_나눠지지않으면_예외를_던진다(int input) {
		String stringInput = String.valueOf(input);

		assertThatThrownBy(() -> new InputMoney(stringInput))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(MONEY_UNIT_ERROR.getMessage());
	}
}
