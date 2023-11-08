package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@DisplayName("설정한 범위의 숫자를 설정한 양만큼 반환한다")
	@Test
	void generate() {
		// given
		int minInclusive = 0;
		int maxInclusive = 9;
		int amount = 6;

		// when
		RandomNumberGenerator generator = new RandomNumberGenerator(minInclusive, maxInclusive, amount);
		List<Integer> randomNumbers = generator.generate();

		// then
		IntStream.range(0, amount)
				.forEach(i -> assertThat(randomNumbers.get(i))
						.isBetween(minInclusive, maxInclusive));

		assertThat(randomNumbers.size()).isEqualTo(amount);
	}
}