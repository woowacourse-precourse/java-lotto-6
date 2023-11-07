package lotto.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class InputValidationTest {

	@Test
	void 유효한_구입금액() {
		// Given
		String validInput = "5000";

		// When
		long price = InputValidation.validatePrice(validInput);

		// Then
		assertEquals(5000L, price);
	}

	@Test
	void 구입금액_숫자가아닐경우() {
		// Given
		String invalidInput = "five thousand";

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> InputValidation.validatePrice(invalidInput));
	}

	@Test
	void 구입금액_천단위아닐때() {
		// Given
		String invalidInput = "2500";

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> InputValidation.validatePrice(invalidInput));
	}

	@Test
	void 유효한_당첨번호() {
		// Given
		List<String> validInput = Arrays.asList("1", "2", "3", "4", "5", "6");

		// When
		List<Integer> numbers = InputValidation.validateWinningNumbers(validInput);

		// Then
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), numbers);
	}

	@Test
	void 당첨번호_숫자가아닐때() {
		// Given
		List<String> invalidInput = Arrays.asList("1", "two", "3", "4", "5", "6");

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> InputValidation.validateWinningNumbers(invalidInput));
	}

	@Test
	void 당첨번호_적게뽑았을때() {
		// Given
		List<String> invalidInput = Arrays.asList("1", "2", "3", "4", "5");

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> InputValidation.validateWinningNumbers(invalidInput));
	}

	@Test
	void 당첨번호_많이뽑았을때() {
		// Given
		List<String> invalidInput = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> InputValidation.validateWinningNumbers(invalidInput));
	}

	@Test
	void 유효한_보너스번호() {
		// Given
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		String validInput = "45";

		// When
		int bonusNumber = InputValidation.validateBonusNumber(winningLotto, validInput);

		// Then
		assertEquals(45, bonusNumber);
	}

	@Test
	void 보너스번호_숫자가아닐경우() {
		// Given
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		String invalidInput = "forty-five";

		// When & Then
		assertThrows(IllegalArgumentException.class,
			() -> InputValidation.validateBonusNumber(winningLotto, invalidInput));
	}
}