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

	@DisplayName("length가 String배열의 길이와 값이 다르면 예외처리한다.")
	@MethodSource("createCheckStrArrLengthMethodParameter")
	@ParameterizedTest
	void checkStrArrLength(String[] strArr, int wrongLength, int correctLength) {
		assertThatThrownBy(() -> Validator.validateStrArrLength(strArr, wrongLength, message))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(message);
	}

	static Stream<Arguments> createCheckStrArrLengthMethodParameter() {
		return Stream.of(Arguments.of(new String[] { "test1", "test2", "test3" }, 2, 3),
				Arguments.of(new String[] { "value1", "value2" }, 1, 2),
				Arguments.of(new String[] { "A", "B", "C", "D" }, 3, 4));
	}

	@DisplayName("리스트의 길이가 기대값과 다를 때 예외 처리합니다.")
	@MethodSource("createCheckSizeMethodParameter")
	@ParameterizedTest
	void checkNumbersSize(List<Integer> numbers, int wrongSize, int correctSize) {
		assertThatThrownBy(() -> Validator.validateSize(numbers, wrongSize, message))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(message);
	}

	static Stream<Arguments> createCheckSizeMethodParameter() {
		return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 5), 6, 5),
				Arguments.of(List.of(10, 20, 30), 4, 3),
				Arguments.of(List.of(1, 2, 3, 4), 0, 4));
	}

	@DisplayName("리스트에 중복된 숫자가 있을 때 예외 처리합니다.")
	@MethodSource("createCheckDuplicateNumberMethodParameter")
	@ParameterizedTest
	void checkDuplicateNumber(List<Integer> numbers) {
		assertThatThrownBy(() -> Validator.validateDuplicateNumber(numbers, message))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(message);
	}

	static Stream<Arguments> createCheckDuplicateNumberMethodParameter() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5)),
				Arguments.of(Arrays.asList(10, 20, 30, 10, 30)),
				Arguments.of(Arrays.asList(1, 2, 3, 5, 5)));
	}

	@DisplayName("리스트의 숫자 중 하나가 범위 밖에 있을 때 예외 처리합니다.")
	@MethodSource("createCheckNumbersOutOfRangeMethodParameter")
	@ParameterizedTest
	void checkNumbersOutOfRange(List<Integer> numbers, int[] ranges) {
		assertThatThrownBy(() -> Validator.validateNumbersOutOfRange(numbers, ranges, message))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(message);
	}

	static Stream<Arguments> createCheckNumbersOutOfRangeMethodParameter() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5), new int[] { 10, 20 }),
				Arguments.of(Arrays.asList(10, 20, 30), new int[] { 40, 50 }),
				Arguments.of(Arrays.asList(1, 2, 3, 4), new int[] { 6, 7 }));
	}

	@DisplayName("숫자가 범위 밖에 있을 때 예외 처리합니다.")
	@MethodSource("createCheckNumberOutOfRangeMethodParameter")
	@ParameterizedTest
	void checkNumberOutOfRange(int number, int[] ranges) {
		assertThatThrownBy(() -> Validator.validateNumberOutOfRange(number, ranges, message))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(message);
	}

	static Stream<Arguments> createCheckNumberOutOfRangeMethodParameter() {
		return Stream.of(Arguments.of(6, new int[] { 1, 5 }), Arguments.of(40, new int[] { 30, 35 }),
				Arguments.of(2, new int[] { 3, 4 }));
	}

	@DisplayName("리스트의 숫자 중 하나가 포함되어 있을 때 예외 처리합니다.")
	@MethodSource("createCheckNumberInNumbersMethodParameter")
	@ParameterizedTest
	void checkNumberInNumbers(List<Integer> numbers, int number) {
		assertThatThrownBy(() -> Validator.validateNumberInNumbers(numbers, number, message))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(message);
	}

	static Stream<Arguments> createCheckNumberInNumbersMethodParameter() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 3),
				Arguments.of(Arrays.asList(10, 20, 30), 20),
				Arguments.of(Arrays.asList(1, 2, 3, 4), 4));
	}
}
