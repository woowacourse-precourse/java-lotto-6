package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.validator.Validator;

public class ValidatorTest {

	private String message;

	@BeforeEach
	void setup() {
		message = "테스트메세지";
	}

	@DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외처리한다.")
	@ValueSource(strings = { "#12", "0s12", ",.!" })
	@ParameterizedTest
	void checkNumberFormat(String str) {
		assertThatThrownBy(() -> Validator.validateNumberFormat(str, message))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}

	@DisplayName("값이 비어있을 때 예외처리한다.")
	@ValueSource(strings = { "", " ", "     " })
	@ParameterizedTest
	void checkIsEmpty(String str) {
		assertThatThrownBy(() -> Validator.validateIsEmpty(str, message))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}
}
