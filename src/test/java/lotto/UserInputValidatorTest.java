package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.LottoError;
import lotto.enums.PriceInputError;

class UserInputValidatorTest {

	@DisplayName("하나의 숫자 입력시 정상 통과")
	@Test
	void validateInputNumberSuccess() {
		String input = "42";
		int result = UserInputValidator.validateInputNumber(input);
		assertThat(result).isEqualTo(42);
	}

	@DisplayName("숫자가 아닌 하나의 문자가 입력됐을 시 예외 발생")
	@Test
	void validateInputNumberFail() {
		String input = "abc";
		assertThatThrownBy(() -> UserInputValidator.validateInputNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(PriceInputError.INVALID_TYPE_INPUT.getErrorDescription());
	}

	@DisplayName(", 로 나누어진 문자열이 전부 숫자이면 통과")
	@Test
	void validateInputNumbersSuccess() {
		String input = "1,2,3,4,5,6";
		List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> result = UserInputValidator.validateInputNumbers(input);
		assertThat(result).containsExactlyElementsOf(expectedNumbers);
	}

	@DisplayName(", 로 나누어진 문자열에 숫자 이외의 것이 포함돼 있으면 에외 발생")
	@Test
	void validateInputNumbersFail() {
		String input = "1,2,x,4,5,6";
		assertThatThrownBy(() -> UserInputValidator.validateInputNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(LottoError.INVALID_INPUT_NUMBER.getErrorDescription());
	}
}