package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.ErrorMessage;

class LottoTest {

	private List<Integer> validNumbers;
	private List<Integer> duplicateNumbers;
	private List<Integer> invalidSizeNumbers;

	@BeforeEach
	void setUp() {
		validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		duplicateNumbers = Arrays.asList(1, 2, 3, 3, 4, 5);
		invalidSizeNumbers = Arrays.asList(1, 2, 3, 4, 5);
	}

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 유효한_로또번호() {
		assertDoesNotThrow(() -> new Lotto(validNumbers));
	}

	@Test
	void 중복시_예외발생() {
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> new Lotto(duplicateNumbers)
		);
		assertEquals(ErrorMessage.DUPLICATED_ERROR.getMessage(), exception.getMessage());
	}

	@Test
	void 개수가_여섯개가_아닐경우_예외() {
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> new Lotto(invalidSizeNumbers)
		);
		assertEquals(ErrorMessage.INPUT_COUNT_ERROR.getMessage(), exception.getMessage());
	}

	@Test
	void 유효한_포함_메서드() {
		Lotto lotto = new Lotto(validNumbers);
		assertTrue(lotto.contains(1));
	}

	@Test
	void 유효하지않은_포함_메서드() {
		Lotto lotto = new Lotto(validNumbers);
		assertFalse(lotto.contains(7));
	}

	@Test
	void 유효한_개수_카운트() {
		Lotto lotto = new Lotto(validNumbers);
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
		assertEquals(3, lotto.getMatchCount(winningNumbers));
	}

	@Test
	void 맞는_번호가_없을경우() {
		Lotto lotto = new Lotto(validNumbers);
		List<Integer> winningNumbers = Arrays.asList(10, 11, 12, 13, 14, 15);
		assertEquals(0, lotto.getMatchCount(winningNumbers));
	}
}