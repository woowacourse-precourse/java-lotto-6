package lotto.domain;

import static lotto.config.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	private Lotto lotto;
	private Exception exception;

	@Test
	@DisplayName("로또 번호를 올바르게 반환하는지 검증하는 테스트")
	void getNumbers() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

		lotto = new Lotto(numbers);

		assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("정해진 로또 번호 개수가 아닐 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenInvalidSize() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);

		exception = assertThrows(IllegalArgumentException.class, () -> lotto = new Lotto(numbers));

		assertEquals(exception.getMessage(), INVALID_LOTTO_SIZE.getMessage());
	}

	@Test
	@DisplayName("정해진 로또 번호의 범위가 아닐 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenInvalidNumberRange() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 50);

		exception = assertThrows(IllegalArgumentException.class, () -> lotto = new Lotto(numbers));

		assertEquals(exception.getMessage(), INVALID_LOTTO_NUMBER.getMessage());
	}

	@Test
	@DisplayName("로또 번호가 중복일 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenDuplicateNumber() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

		exception = assertThrows(IllegalArgumentException.class, () -> lotto = new Lotto(numbers));

		assertEquals(exception.getMessage(), DUPLICATE_LOTTO_NUMBER.getMessage());
	}
}