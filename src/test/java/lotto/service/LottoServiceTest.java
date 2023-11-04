package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoServiceTest {

	private LottoService lottoService;
	private int money;
	private int lottoPriceSum;
	private double totalReturn;

	@BeforeEach
	void setup() {
		lottoService = new LottoService();
		money = 4000;
	}

	@DisplayName("로또들의 총상금의 합을 확인한다.")
	@MethodSource("createCheckLottoPriceSumMethodParameter")
	@ParameterizedTest()
	void checkLottoPriceSum(AnswerLotto answerLotto, Lottos lottos, int expect) {
		lottoPriceSum = lottoService.calculateLottoPriceSum(lottos, answerLotto);

		assertEquals(lottoPriceSum, expect);
	}

	

	static Stream<Arguments> createCheckLottoPriceSumMethodParameter() {
		AnswerLotto answerLotto = new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 11, 12, 13)),
				new Lotto(List.of(1, 2, 3, 4, 12, 13)), new Lotto(List.of(8, 9, 10, 11, 12, 13))));
		
		return Stream.of(Arguments.of(answerLotto, lottos, 55000));
	}

	
}
