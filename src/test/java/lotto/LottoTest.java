package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.validator.InputException;
import lotto.validator.Lotto;

class LottoTest {

	@DisplayName("구매금액이 1000단위가 아니면 예외를 발생한다.")
	@Test
	void createOutOfThousand() {
		assertThatIllegalArgumentException().isThrownBy(() -> InputException.checkOutOfNumber("200"));
	}

	@DisplayName("숫자가 아니면 예외가 발생한다.")
	@Test
	void createOutOfNumber() {
		assertThatIllegalArgumentException().isThrownBy(() -> InputException.checkOutOfNumber("1000j"));
	}

	@DisplayName("빈문자열이면 예외가 발생한다.")
	@Test
	void createEmpty() {
		assertThatIllegalArgumentException().isThrownBy(() -> InputException.checkEmpty(""));
	}

	@DisplayName("공백이면 예외가 발생한다.")
	@Test
	void createBlank() {
		assertThatIllegalArgumentException().isThrownBy(() -> InputException.checkBlank(" "));
	}

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
	@Test
	void createLottoByLessSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {

		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또번호에 앞에 콤마가 있으면 예외가 발생한다.")
	@Test
	void createCommaFont() {
		assertThatIllegalArgumentException().isThrownBy(() -> InputException.checkComma(",1,2,3,4,5,6"));
	}

	@DisplayName("로또번호에 뒤에 콤마가 있으면 예외가 발생한다.")
	@Test
	void createCommaBack() {
		assertThatIllegalArgumentException().isThrownBy(() -> InputException.checkComma("1,2,3,4,5,6,"));
	}

	@DisplayName("당첨번호에 있는 번호를 보너스 번호로 입력하면 예외가 발생한다.")
	@Test
	void createBonusDuplication() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> InputException.checkDuplication(7, List.of(1, 2, 3, 4, 5, 7)));
	}

}