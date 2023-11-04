package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_BONUS_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

	private BonusNumber bonusNumber;
	private Exception exception;

	@Test
	@DisplayName("보너스 번호를 올바르게 반환하는 테스트")
	void getBonusNumber() {
		String number = "1";

		bonusNumber = new BonusNumber(number);

		assertThat(bonusNumber.getBonusNumber()).isEqualTo(1);
	}

	@Test
	@DisplayName("보너스 번호 입력시 공백을 입력하는 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenBlank() {
		String type_blank = "";

		exception = assertThrows(IllegalArgumentException.class, () -> bonusNumber = new BonusNumber(type_blank));

		assertEquals(exception.getMessage(), BLANK_BONUS_NUMBER.getMessage());
	}

	@Test
	@DisplayName("보너스 번호 입력시 문자를 입력하는 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenString() {
		String type_string = "사십사";

		exception = assertThrows(IllegalArgumentException.class, () -> bonusNumber = new BonusNumber(type_string));

		assertEquals(exception.getMessage(), INVALID_LOTTO_NUMBER.getMessage());
	}

	@Test
	@DisplayName("보너스 번호가 로또 번호의 범위가 아닐 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenInvalidNumberRange() {
		String type_over_range = "50";

		exception = assertThrows(IllegalArgumentException.class, () -> bonusNumber = new BonusNumber(type_over_range));

		assertEquals(exception.getMessage(), INVALID_LOTTO_NUMBER.getMessage());
	}
}