package lotto;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidateInputTest {
	@Test
	public void testValidateLottoPriceWhenCorrect() {
		ValidateInput validator = new ValidateInput();
		String input = "6000";
		int result = validator.validateLottoPrice(input);
		assertEquals(6, result);
	}

	@Test
	public void testValidateLottoPriceWhenNotCorrect() {
		ValidateInput validator = new ValidateInput();
		String input = "5001";
		try {
			validator.validateLottoPrice(input);
			fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("[ERROR] 천원 단위로 금액을 입력해주세요", e.getMessage());
		}
	}

	@Test
	public void testValidateWinningNumberSplit() {
		ValidateInput validator = new ValidateInput();
		String winNumber = "1, 2, 3, 4, 5, 6";
		List<Integer> result = validator.validateWinningNumber(winNumber);
		assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
	}

	@Test
	public void testValidateWinningNumberWhenNumberOutOfRange() {
		ValidateInput validator = new ValidateInput();
		String winNumber = "1, 2, 3, 4, 5, 60";
		try {
			validator.validateWinningNumber(winNumber);
		} catch (IllegalArgumentException e) {
			assertEquals("[ERROR] 당첨 번호를 확인해주세요", e.getMessage());
		}
	}

	@Test
	public void testValidateBonus() {
		ValidateInput validator = new ValidateInput();
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		String inputBonus = "7";
		int result = validator.validateBonus(inputBonus, winningNumbers);
		assertEquals(7, result);
	}

	@Test
	public void testValidateBonusWhenBonusInWinningNumber() {
		ValidateInput validator = new ValidateInput();
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		String inputBonus = "6";
		try {
			validator.validateBonus(inputBonus, winningNumbers);
		} catch (IllegalArgumentException e) {
			assertEquals("[ERROR] 보너스 숫자가 당첨 숫자와 중복됩니다.", e.getMessage());
		}
	}

}
