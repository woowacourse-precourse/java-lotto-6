package lotto.ui;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {

	@DisplayName("string 함수는 입력 시 문자열을 반환한다.")
	@Test
	void 문자열_입력_테스트() {
		// given
		Printable printable = () -> "test";
		// when
		run("test2");
		String string = Input.string(printable);
		// then
		assertEquals(output(), "test");
		assertEquals(string, "test2");
	}

	@DisplayName("integer 함수는 입력 시 정수를 반환한다.")
	@Test
	void 정수_입력_테스트() {
		// given
		Printable printable = () -> "test";
		// when
		run("1");
		Integer integer = Input.integer(printable);
		// then
		assertEquals(output(), "test");
		assertEquals(integer, 1);
	}

	@DisplayName("integerList 함수는 입력 시 정수 리스트를 반환한다.")
	@Test
	void 정수_리스트_입력_테스트() {
		// given
		Printable printable = () -> "test";
		// when
		run("1,2,3");
		var integerList = Input.integerList(printable);
		// then
		assertEquals(output(), "test");
		assertEquals(integerList, List.of(1, 2, 3));
	}

	@Override
	protected void runMain() {

	}
}