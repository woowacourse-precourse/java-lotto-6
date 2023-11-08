package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Prize.FIRST_PLACE;
import static lotto.domain.Prize.FIFTH_PLACE;
import static lotto.domain.Prize.LAST_PLACE;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("당첨 내역 계산")
class LottoResultTest {

	@DisplayName("수익률 계산 성공 테스트")
	@ParameterizedTest()
	@MethodSource("calculateBenefitSuccessDummy")
	void calculateBenefitSuccessTest(final LottoResult lottoResult, final Integer totalSpendAmount,
		final Double expected) {
		final Double result = lottoResult.getRoundedTotalBenefit(totalSpendAmount);
		assertEquals(expected, result);
	}


	static Stream<Arguments> calculateBenefitSuccessDummy() {
		return Stream.of(
			Arguments.arguments(
				LottoResult.create(
					List.of(FIFTH_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE,
						LAST_PLACE, LAST_PLACE)
				),
				8000,
				62.5
			),
			Arguments.arguments(
				LottoResult.create(
					List.of(FIFTH_PLACE, FIFTH_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE,
						LAST_PLACE, LAST_PLACE, LAST_PLACE)
				),
				8000,
				125.0
			),
			Arguments.arguments(
				LottoResult.create(
					List.of(FIRST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE,
						LAST_PLACE, LAST_PLACE)
				),
				8000,
				25000000.0
			)
		);
	}
}