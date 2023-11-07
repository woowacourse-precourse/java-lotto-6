package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {
	@Test
	@DisplayName("조건을 충족하면 정상적으로 WinningNumbers가 만들어진다.")
	void testValidWinningNumbers() {
		String validWinningNumbers = "1,2,3,4,5,6";
		WinningNumbers winningNumbers = new WinningNumbers(validWinningNumbers);
		assertNotNull(winningNumbers);
	}

	@ParameterizedTest
	@MethodSource("invalidWinningNumbers")
	@DisplayName("조건을 충족하지 않으면 Exception이 발생한다.")
	void testInvalidWinningNumbers(String invalidNumbers) {
		assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(invalidNumbers));
	}

	private static Stream<String> invalidWinningNumbers() {
		return Stream.of(
			"1,2,3,4,5,6,7",
			"1,2,3,4,5",
			"0,2,3,4,5,6",
			"1,2,3,3,4,5",
			"1,2,3,4,5,a"
		);
	}
}
