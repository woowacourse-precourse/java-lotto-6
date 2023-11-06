package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberUtilTest {

	@Test
	void isNumeric_true() {
		String money = "1000";

		boolean result = NumberUtil.isNumericBonusNumber(money);

		assertThat(result).isTrue();
	}

	@Test
	void isNumeric_false() {
		String money = "천원";

		boolean result = NumberUtil.isNumericBonusNumber(money);

		assertThat(result).isFalse();
	}

	@Test
	void isLottoNumberRange_true() {
		int number = 45;

		boolean result = NumberUtil.isLottoNumberRange(number);

		assertThat(result).isTrue();
	}

	@Test
	void isLottoNumberRange_false() {
		int number = 55;

		boolean result = NumberUtil.isLottoNumberRange(number);

		assertThat(result).isFalse();
	}
}