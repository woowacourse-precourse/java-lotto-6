package lotto.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

public class LottoNumberGeneratorTest {

	@DisplayName("생성된 번호들의 범위와 사이즈를 확인한다.")
	@Test
	void checkGeneratedNumbersSizeAndRange() {

		LottoNumberGenerator generator = new LottoNumberGenerator();
		List<Integer> numbers = generator.generate();

		assertNotNull(numbers);
		assertEquals(Lotto.LOTTO_SIZE, numbers.size());

		for (int number : numbers) {
			assertTrue(number >= Lotto.MIN_NUMBER && number <= Lotto.MAX_NUMBER);
		}
	}
}