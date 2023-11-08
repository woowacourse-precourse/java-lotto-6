package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 발행기")
class UniqueRandomNumbersGeneratorTest {

	private static final Integer LOTTO_LENGTH = 6;
	private static final Integer RANGE_START_NUMBER = 1;
	private static final Integer RANGE_END_NUMBER = 45;
	final NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();

	@DisplayName("발행된 숫자 번호 허용 범위 테스트")
	@RepeatedTest(5)
	void generateNumbersIncludeRangeTest() {
		final List<Integer> numbers = numberGenerator.generateNumbers();
		final boolean result = numbers.stream()
			.allMatch(number
				-> RANGE_START_NUMBER <= number && number <= RANGE_END_NUMBER
			);
		assertEquals(true, result);

	}

	@DisplayName("발행된 숫자 번호 중복 여부 테스트")
	@RepeatedTest(5)
	void generateNumbersDuplicatedNumberTest() {
		final List<Integer> numbers = numberGenerator.generateNumbers();
		final int result = numbers.stream()
			.collect(Collectors.toSet())
			.size();

		assertEquals(LOTTO_LENGTH, result);

	}

	@DisplayName("발행된 숫자 개수 테스트")
	@RepeatedTest(5)
	void generateNumbersSizeTest() {
		final List<Integer> numbers = numberGenerator.generateNumbers();
		final int result = numbers.size();
		assertEquals(LOTTO_LENGTH, result);
	}

}