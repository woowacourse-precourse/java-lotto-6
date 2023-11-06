package lotto.generate;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

	@Test
	void test() {
		int test = 3;
		RandomGenerator generator = new RandomGenerator(test);
		assertThat(generator.myLotto.size()).isEqualTo(test);
	}

}
