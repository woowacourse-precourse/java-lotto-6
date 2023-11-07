package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.exception.ErrorMessage;

public class WinningResultTest {

	private Lotto winningLotto;
	private int validBonusNumber;
	private int invalidBonusNumberOutOfRange;
	private int invalidBonusNumberDuplicated;

	@BeforeEach
	void setUp() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		winningLotto = new Lotto(winningNumbers);
		validBonusNumber = 7; // 당첨 번호가 아닌 유효한 보너스 번호
		invalidBonusNumberOutOfRange = 46; // 범위를 벗어난 보너스 번호
		invalidBonusNumberDuplicated = 1; // 당첨 번호 리스트에 있는 중복된 보너스 번호
	}

	@Test
	void 유효한_보너스번호_예외처리_안함() {
		assertDoesNotThrow(() -> new WinningResult(winningLotto, validBonusNumber));
	}

	@Test
	void 유효하지_않은_보너스번호_예외처리() {
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> new WinningResult(winningLotto, invalidBonusNumberOutOfRange)
		);
		assertEquals(ErrorMessage.RANGE_ERROR.getMessage(), exception.getMessage());
	}

	@Test
	void 보너스번호_중복발생시_예외처리() {
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> new WinningResult(winningLotto, invalidBonusNumberDuplicated)
		);
		assertEquals(ErrorMessage.DUPLICATED_ERROR.getMessage(), exception.getMessage());
	}
}
