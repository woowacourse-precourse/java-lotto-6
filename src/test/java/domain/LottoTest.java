package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
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

	@DisplayName("로또 입력시 숫자와 쉼표 사이에 공백이 있으면 제거")
	@Test
	public void shouldRemoveSpacesBetweenNumbersAndCommas() {
		//given
		String inputData = "1,2,3, 4,  5,6";
		String expected = "1,2,3,4,5,6";
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		// when
		String lottoNumbers = lotto.removeSpacesBetweenNumbersAndCommas(inputData);

		//then
		Assertions.assertThat(lottoNumbers).isEqualTo(expected);
	}

	@DisplayName("로또 번호 입력시 숫자가 아닌 값이 있으면 예외 발생")
	@Test
	public void checkListDigitWithString() {
		// given
		String input = "1,2,3,4,a,!";

		// when & then
		assertThatThrownBy(() -> new Lotto(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호 입력시 6개가 아니면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
	public void checkListLength(String input) {
		// when & then
		assertThatThrownBy(() -> new Lotto(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("모든 값이 1~45 사이의 값이 아니라면 예외 발생")
	@Test
	public void checkOutOfRangeNumbers() {
		//given
		String input = "1,2,3,4,44,48";

		// when & then
		assertThatThrownBy(() -> new Lotto(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
