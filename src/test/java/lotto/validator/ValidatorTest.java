package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.message.ErrorMessage;
import lotto.util.validator.Validator;

public class ValidatorTest {

	@DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외처리한다.")
	@ValueSource(strings = { "#12", "0s12", ",.!" })
	@ParameterizedTest
	void checkNumberFormat(String str) {
		assertThatThrownBy(() -> Validator.validateNumberFormat(str, ErrorMessage.INPUT_LETTER_ERROR.getMessage()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}

	@DisplayName("숫자만을 입력했을 떄 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "456" })
	@ParameterizedTest
	void checkNomalOperation1(String str) {
		Validator.validateNumberFormat(str, ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}

	@DisplayName("값이 비어있을 때 예외처리한다.")
	@ValueSource(strings = { "", " ", "     " })
	@ParameterizedTest
	void checkisEmpty(String str) {
		assertThatThrownBy(() -> Validator.validateIsEmpty(str, ErrorMessage.INPUT_EMPTY_ERROR.getMessage()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
	}

	@DisplayName("값이 있을 떄 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "456", "a" })
	@ParameterizedTest
	void checkNomalOperation2(String str) {
		Validator.validateIsEmpty(str, ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
	}
	
	@DisplayName("length가 String배열의 길이와 값이 다르면 예외처리한다.")
	@MethodSource("createCheckStrArrLengthMethodParameter")
    @ParameterizedTest
    void checkStrArrLength(String[] strArr, int wrongLength, int correctLength) {
        assertThatThrownBy(() -> Validator.validateStrArrLength(strArr, wrongLength, "테스트메세지"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("테스트메세지");
    }
	
	@DisplayName("length가 String배열의 길이와 같을 때 정상적으로 작동하는 지 확인한다.")
	@MethodSource("createCheckStrArrLengthMethodParameter")
    @ParameterizedTest
    void checkNomalOperation3(String[] strArr, int wrongLength, int correctLength) {
		Validator.validateStrArrLength(strArr, correctLength, "테스트메세지");
    }
	
    static Stream<Arguments> createCheckStrArrLengthMethodParameter() {
        return Stream.of(
                Arguments.of(new String[] { "test1", "test2", "test3" }, 2, 3),
                Arguments.of(new String[] { "value1", "value2" }, 1, 2),
                Arguments.of(new String[] { "A", "B", "C", "D" }, 3, 4)
        );
    }
}
