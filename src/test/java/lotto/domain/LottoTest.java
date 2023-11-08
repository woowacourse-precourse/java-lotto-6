package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("Lotto 생성자 테스트")
	public void testValidLottoCreation() {
		// Given
		List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// When
		Lotto lotto = new Lotto(validNumbers);

		// Then
		assertEquals(validNumbers, lotto.getNumbers());
	}

	@Test
	@DisplayName("Lotto 생성자 테스트 - 6개의 숫자가 아닌 경우")
	public void testInvalidLottoCreation_Size() {
		// Given
		List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

		// When and Then
		assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
	}

	@Test
	@DisplayName("Lotto 생성자 테스트 - 중복된 숫자가 있는 경우")
	public void testInvalidLottoCreation_DuplicateNumbers() {
		// Given
		List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 4, 5);

		// When and Then
		assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
	}

	@Test
	@DisplayName("Lotto 생성자 테스트 - 범위를 벗어난 숫자가 있는 경우")
	public void testInvalidLottoCreation_OutOfRange() {
		// Given
		List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 50);

		// When and Then
		assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
	}
}
