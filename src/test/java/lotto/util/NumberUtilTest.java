package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberUtilTest {


	@Test
	void isNumeric_true() {
		String test = "1000";

		boolean result = NumberUtil.isNumeric(test);

		assertThat(result).isTrue();
	}

	@Test
	void isNumeric_false() {
		String test = "천원";

		boolean result = NumberUtil.isNumeric(test);

		assertThat(result).isFalse();
	}
}