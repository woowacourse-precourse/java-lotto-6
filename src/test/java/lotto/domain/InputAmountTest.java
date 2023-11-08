package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputAmountTest {
	@Test
	void 금액을_구입갯수로_변환하여_새로운객체를_생성한다() {
		int input = 1_000;
		int expected = 1;
		InputAmount inputAmount = new InputAmount(input);

		Assertions.assertThat(inputAmount.getInputAmount()).isEqualTo(expected);
	}
}
