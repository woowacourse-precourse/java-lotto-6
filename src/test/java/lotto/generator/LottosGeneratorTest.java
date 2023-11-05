package lotto.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lottos;
import lotto.domain.Money;

public class LottosGeneratorTest {

	private LottosGenerator lottosGenerator;

	@BeforeEach
	void setUp() {
		lottosGenerator = new LottosGenerator();
	}

	@DisplayName("돈을 1000으로 나눈 몫만큼 Lotto가 생성되는 지 확인한다.")
	@MethodSource("createGenerateMethodParameter")
	@ParameterizedTest
	void checkGenerateLottos(int inputValue, int expect) {
		Money money = new Money(inputValue);
		lottosGenerator.setMoney(money);

		Lottos lottos = lottosGenerator.generate();

		assertEquals(lottos.size(), expect);
	}

	static Stream<Arguments> createGenerateMethodParameter() {
		return Stream.of(Arguments.of(10000, 10), Arguments.of(2000, 2), Arguments.of(8000, 8));
	}
}
