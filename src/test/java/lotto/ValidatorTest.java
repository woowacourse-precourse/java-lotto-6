package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidatorTest {
	Validator validator;

	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	@DisplayName("문자열을 받아 숫자로 이루어져 있는지 검사하는 메서드 테스트 - 통과")
	@Test
	void isComposedOfNumbersTest() {
		String check = "123";
		assertDoesNotThrow(() -> validator.isComposedOfNumbers(check));
	}

	@DisplayName("문자열을 받아 숫자로 이루어져 있는지 검사하는 메서드 테스트 - 실패")
	@ParameterizedTest
	@ValueSource(strings = {"r123", "abc"})
	void isComposedOfNumbersTest(String check) {
		assertThatThrownBy(() -> validator.isComposedOfNumbers(check))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[ERROR] 숫자로 이루어져 있지 않습니다.");
	}

	@DisplayName("가격을 받아 1000원 단위인지 검사하는 메서드 테스트")
	@Test
	void isMultiplesOfThousandTest() {

	}

	@DisplayName("문자열을 받아 문자열을 숫자로 파싱하였을 때," +
			" 숫자가 1~45의 범위 안에 있는지 검사하는 메서드 테스트")
	@Test
	void isInRangeTest() {

	}

	@DisplayName("List<Intger>와 문자열을 받아 문자열을 숫자로 파싱하였을 때," +
			" 리스트 안에 숫자가 포함되어 있는지 검사하는 메서드 테스트")
	@Test
	void containNumberTest() {

	}
}
