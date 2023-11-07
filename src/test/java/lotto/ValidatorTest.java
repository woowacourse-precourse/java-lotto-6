package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
	void test1() {
		String check = "123";
		assertDoesNotThrow(() -> validator.checkComposedOfNumbers(check));
	}

	@DisplayName("문자열을 받아 숫자로 이루어져 있는지 검사하는 메서드 테스트 - 실패")
	@ParameterizedTest
	@ValueSource(strings = {"r123", "abc"})
	void test2(String check) {
		assertThatThrownBy(() -> validator.checkComposedOfNumbers(check))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[ERROR] 숫자로 이루어져 있지 않습니다.");
	}

	@DisplayName("가격을 받아 1000원 단위인지 검사하는 메서드 테스트 - 통과")
	@ParameterizedTest
	@ValueSource(longs = {1000L, 3000L, 5000L, 10000L})
	void test3(long check) {
		assertDoesNotThrow(() -> validator.checkMultiplesOfThousand(check));
	}

	@DisplayName("가격을 받아 1000원 단위인지 검사하는 메서드 테스트 - 실패")
	@ParameterizedTest
	@ValueSource(longs = {1001L, 2050L, 900L, 5500L})
	void test4(long check) {
		assertThatThrownBy(() -> validator.checkMultiplesOfThousand(check))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[ERROR] 1000으로 나누어 떨어져야 합니다.");
	}

	@DisplayName("문자열을 받아 문자열을 숫자로 파싱하였을 때," +
			" 숫자가 1~45의 범위 안에 있는지 검사하는 메서드 테스트 - 통과")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 10, 20, 30, 40, 44, 45})
	void test5(int check) {
		assertDoesNotThrow(() -> validator.checkInRange(check));
	}

	@DisplayName("문자열을 받아 문자열을 숫자로 파싱하였을 때," +
			" 숫자가 1~45의 범위 안에 있는지 검사하는 메서드 테스트 - 실패")
	@ParameterizedTest
	@ValueSource(ints = {0, 46, 47})
	void test6(int check) {
		assertThatThrownBy(() -> validator.checkInRange(check))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[ERROR] 1에서 45까지의 범위에 있지 않습니다.");
	}

	@DisplayName("List<Intger>와 문자열을 받아 문자열을 숫자로 파싱하였을 때," +
			" 리스트 안에 숫자가 포함되어 있는지 검사하는 메서드 테스트 - 성공")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void test7(int check) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> validator.checkContainNumber(list, check))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[ERROR] 번호는 중복될 수 없습니다.");
	}

	@DisplayName("List<Intger>와 문자열을 받아 문자열을 숫자로 파싱하였을 때," +
			" 리스트 안에 숫자가 포함되어 있는지 검사하는 메서드 테스트 - 실패")
	@ParameterizedTest
	@ValueSource(ints = {7, 8, 9, 10, 11, 12})
	void test8(int check) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
		assertDoesNotThrow(() -> validator.checkContainNumber(list, check));
	}
}
