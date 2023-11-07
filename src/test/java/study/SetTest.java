package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("size() 메서드는 Set의 크기를 제대로 반환하는지 확인")
	@Test
	void sizeTest() {
		int numbersSize = numbers.size();
		assertEquals(3, numbersSize);
	}

	@DisplayName("contains() 메서드는 set의 원소의 존재를 잘 파악하는지 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void containTest1(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("contains() 메서드는 set의 원소 존재 여부를 잘 파악하는지 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containTest2(int element, boolean expected) {
		assertEquals(numbers.contains(element), expected);
	}


}
