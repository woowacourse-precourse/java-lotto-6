package lotto.generate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

	@DisplayName("구매 금액에 맞는 로또 개수를 출력하는지 테스트")
	@Test
	void test() {
		int test = 3;
		RandomGenerator generator = new RandomGenerator(test);
		assertThat(generator.myLotto.size()).isEqualTo(test);
	}

}
