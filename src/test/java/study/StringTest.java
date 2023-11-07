package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
	@DisplayName("\"1,2\"를 ,로 split했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void splitTest1() {
		String numbers = "1,2";
		String[] split = numbers.split(",");

		assertThat(split).contains("2", "1");
		assertThat(split).containsExactly("1", "2");
	}

	@DisplayName("\"1\"을 ,로 split했을 때 1만을 포함하는 배열이 반환되는지 확인")
	@Test
	void splitTest2() {
		String number = "1";
		String[] split = number.split(",");

		assertEquals(1, split.length);
		assertThat(split).containsExactly("1");
	}

	@DisplayName("\"(1,2)\"의 ()을 substring을 이용하여 제거하여 \"1,2\"가 반환되는지 확인")
	@Test
	void substringTest1() {
		String str = "(1,2)";
		String check = str.substring(1, str.length() - 1);

		assertEquals("1,2", check);
	}

	@DisplayName("charAt() 메서드가 특정 위치의 문자를 잘 가져오는지 확인")
	@Test
	void charAtTest1() {
		String str = "abc";
		char expectedA = str.charAt(0);
		char expectedB = str.charAt(1);
		char expectedC = str.charAt(2);

		assertEquals(expectedA, 'a');
		assertEquals(expectedB, 'b');
		assertEquals(expectedC, 'c');
	}

	@DisplayName("charAt() 메서드에서 위치 값을 벗어나면" +
			"StringIndexOutOfBoundsException이 발생하는지 확인")
	@Test
	void charAtTest2() {
		String str = "abc";
		assertThatThrownBy(() -> str.charAt(3))
				.isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 3");
	}
}
