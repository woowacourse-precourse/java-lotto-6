package lotto.ui;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest extends NsTest {

	@DisplayName("Output 클래스의 output 메서드를 테스트한다.")
	@Test
	void 출력_테스트() {
		// given
		Printable printable = () -> "test";
		// when
		Output.output(printable);
		// then
		assertEquals(output(), "test");
	}

	@DisplayName("Output 클래스의 integerList 메서드를 테스트한다.")
	@Test
	void 정수_리스트_출력_테스트() {
		// given
		List<Integer> numbers = List.of(1, 2, 3);
		// when
		Output.integerList(numbers);
		// then
		assertEquals(output(), "[1, 2, 3]");
	}


	@Override
	protected void runMain() {
	}
}