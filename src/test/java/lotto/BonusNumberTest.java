package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
	@Test
	@DisplayName("조건을 충족하면 정상적으로 BonusNumber이 생성된다.")
	void testValidBonusNumber() {
		String input = "7";
		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
		BonusNumber bonusNumber = new BonusNumber(input, winningNumbers);
		assertTrue(bonusNumber.checkIsMatch(new Lotto(List.of(7, 8, 9, 10, 11, 12))));
	}

	@ParameterizedTest
	@DisplayName("조건을 충족하지 않으면 Exception을 반환한다.")
	@ValueSource(strings = {"abc", "50", "6"})
	void testInvalidBonusNumber(String input) {
		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
		assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input, winningNumbers));
	}


}
