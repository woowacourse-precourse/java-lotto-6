package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;
	
	@BeforeEach
	void SetUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}
	
	@DisplayName("Set의 size 메서드를 활용하여 Set 크기 확인")
	@Test
	void size_메서드_활용하여_Set_크기_확인() {
		int size = numbers.size();
		
		assertThat(size).isEqualTo(3);
	}
	
	@DisplayName("ValueSource를 이용한 Set 포함 여부 확인")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}
	
	@DisplayName("CsvSource를 이용한 Set 포함 여부 및 결과 예상값 확인")
	@ParameterizedTest
	@CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
	void contains(int number, boolean expected) {
	    assertThat(numbers.contains(number)).isEqualTo(expected);
	}

}
