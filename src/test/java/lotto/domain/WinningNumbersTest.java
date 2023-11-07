package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_WINNING_NUMBERS;
import static lotto.config.ErrorMessage.INVALID_WINNING_NUMBERS;
import static lotto.config.ErrorMessage.OVERLAPPED_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

	private WinningNumbers winningNumbers;
	private Exception exception;

	@Test
	@DisplayName("당첨 번호를 올바르게 반환하는지 테스트")
	void getWinningNumbers() {
		String numbers = "1,2,3,4,5,6";

		winningNumbers = new WinningNumbers(numbers);

		assertThat(winningNumbers.getWinningNumbers()).isInstanceOf(Lotto.class);
		assertThat(winningNumbers.getWinningNumbers().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("당첨 번호 입력시 공백을 입력할 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenBlank() {
		String type_blank = "";

		exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers = new WinningNumbers(type_blank));

		assertEquals(exception.getMessage(), BLANK_WINNING_NUMBERS.getMessage());
	}

	@Test
	@DisplayName("당첨 번호 입력시 문자를 입력할 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenNonNumeric() {
		String type_string = "일,이,삼,사,오,육";

		exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers = new WinningNumbers(type_string));

		assertEquals(exception.getMessage(), INVALID_WINNING_NUMBERS.getMessage());
	}

	@Test
	@DisplayName("당첨 번호 입력시 쉼표(,)를 기준으로 입력을 안할 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenNonComma() {
		String type_nonComma = "1/2/3/4/5/6";

		exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers = new WinningNumbers(type_nonComma));

		assertEquals(exception.getMessage(), INVALID_WINNING_NUMBERS.getMessage());
	}


	@Test
	@DisplayName("당첨번호와 보너스번호의 중복이 있을 경우 IllegalArgumentException 이 발생한다.")
	void checkDuplicationBonusNumber() {
		BonusNumber bonusNumber = new BonusNumber("6");
		winningNumbers = new WinningNumbers("1,2,3,4,5,6");

		exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.checkDuplicationBonusNumber(bonusNumber));

		assertEquals(exception.getMessage(), OVERLAPPED_BONUS_NUMBER.getMessage());
	}

	@Test
	@DisplayName("당첨 번호에 포함되어 있을 경우 true 를 반환")
	void contains_true() {
		int number = 6;
		winningNumbers = new WinningNumbers("1,2,3,4,5,6");

		boolean result = winningNumbers.contains(number);

		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("당첨 번호에 포함되어 있지 않을 경우 false 를 반환")
	void contains_false() {
		int number = 7;
		winningNumbers = new WinningNumbers("1,2,3,4,5,6");

		boolean result = winningNumbers.contains(number);

		assertThat(result).isFalse();
	}
}