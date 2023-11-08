package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.validator.Validator;
import lotto.view.InputView;

public class ValidatorTest {

	private String message;

	@BeforeEach
	void setup() {
		message = "테스트메세지";
	}

	@DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외처리한다.")
	@ValueSource(strings = { "#12", "0s12", ",.!" })
	@ParameterizedTest
	void checkNumberFormat(String param) {
		assertThatThrownBy(() -> Validator.validateSpecificFormat(InputView.NUMBER_FORMAT, param, message))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}

	@DisplayName("값이 비어있을 때 예외처리한다.")
	@ValueSource(strings = { "", " ", "     " })
	@ParameterizedTest
	void checkIsEmpty(String param) {
		assertThatThrownBy(() -> Validator.validateIsEmpty(param, message))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}

	@DisplayName("num1,num2,num3...의 형태로 ,로 구분되는 숫자의 갯수가 LOTTO_SIZE가 아니라면 예외처리한다.")
	@ValueSource(strings = { "1,2,3,4", "1.2.3.4", "1;", "a,b,2,3,4,5", " "})
	@ParameterizedTest
	void checkInputAnswerLottoNumbersFormat(String param) {
		assertThatThrownBy(() -> Validator.validateSpecificFormat(
				InputView.INPUT_ANSWER_LOTTO_NUMBERS_FORMAT, param, message))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining(message);
	}
}
