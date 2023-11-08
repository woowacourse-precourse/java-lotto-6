package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("split 함수를 사용해 구분자로 값을 구분할 수 있는지 확인한다.")
	@Test
	void split_메서드_값_구분() {
		String input = "1,2";
		String[] result = input.split(",");

		assertThat(result).contains("2", "1");
		assertThat(result).containsExactly("1", "2");
	}

	@DisplayName("split 함수에 구분자가 포함되지 않아도 동작하는지 확인한다.")
	@Test
	void split_메서드_구분자_포함하지_않을_경우_값_그대로_반환() {
		String input = "1";
		String[] result = input.split(",");

		assertThat(result).contains("1");
	}

	@DisplayName("substring 함수를 사용해 지정된 구간의 값이 반환되는지 확인한다.")
	@Test
	void substring_메서드_지정된_구간_반환() {
		String input = "(1,2)";
		String result = input.substring(1, 4);

		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("charAt 함수를 사용해 문자열의 특정 위치의 문자가 반환되는지 확인한다.")
	@Test
	void charAt_메서드를_활용해_특정_위치의_문자_반환() {
		String input = "abc";
		char result = input.charAt(1);

		assertThat(result).isEqualTo('b');
	}

	@DisplayName("charAt 함수를 사용할 때 문자열의 길이보다 더 큰 위치의 문자를 찾을 경우 예외가 발생하는지 확인한다.")
	@Test
	void charAt_메서드_사용시_문자열의_길이보다_더_큰_위치의_문자를_찾을_경우_예외_발생() {
		String input = "abc";

		assertThatThrownBy(() -> input.charAt(5))
				.isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 5");
	}

}
