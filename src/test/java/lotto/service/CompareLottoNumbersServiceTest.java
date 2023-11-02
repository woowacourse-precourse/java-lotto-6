package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;

public class CompareLottoNumbersServiceTest {

	private final CompareLottoNumbersService service = new CompareLottoNumbersService();

	@DisplayName("일치한 로또 번호 수와 보너스 번호 유뮤에 따른 로또 상금을 확인한다.")
	@MethodSource("createCheckWinningLottoNumbersServiceMethodParameter")
	@ParameterizedTest
	void checkWinningLottoCountAndBonusNumber(AnswerLotto answerLotto, Lotto lotto, int expect, boolean isBonus) {
		int winningNumberCount = service.getWinningNumberCount(answerLotto, lotto);

		boolean isBonusNumber = service.checkSameAsBonusNumber(answerLotto, lotto);

		assertEquals(winningNumberCount, expect);
		assertEquals(isBonusNumber, isBonus);
	}

	static Stream<Arguments> createCheckWinningLottoNumbersServiceMethodParameter() {
		return Stream.of(
				Arguments.of(new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7), new Lotto(List.of(1, 2, 3, 9, 10, 11)), 3,
						false),
				Arguments.of(new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7), new Lotto(List.of(1, 2, 3, 4, 10, 7)), 4,
						true));
	}
}
