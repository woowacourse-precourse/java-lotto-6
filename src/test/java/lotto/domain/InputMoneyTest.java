package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputMoneyTest {
	@Test
	void 입력값을_검증하고_객체를_생성한다() {
		String input = "1000";
		MoneyValidator moneyValidator = new MoneyValidator();
		InputMoney inputMoney = new InputMoney(moneyValidator, input);

		assertThat(inputMoney.getInputMoney()).isEqualTo(Integer.parseInt(input));
	}
}
