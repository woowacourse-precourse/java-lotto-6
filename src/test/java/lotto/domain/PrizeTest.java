package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static lotto.domain.Prize.FIRST_PLACE;
import static lotto.domain.Prize.SECOND_PLACE;
import static lotto.domain.Prize.THIRD_PLACE;
import static lotto.domain.Prize.FOURTH_PLACE;
import static lotto.domain.Prize.FIFTH_PLACE;
import static lotto.domain.Prize.LAST_PLACE;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("당첨")
class PrizeTest {

	@DisplayName("생성 성공 테스트")
	@ParameterizedTest()
	@MethodSource("createPrizeSuccessDummy")
	void createPrizeSuccessTest(final Integer countOfSameNumber, final Boolean checkBonus,
		final Prize expected) {
		final Prize result = Prize.of(countOfSameNumber, checkBonus);
		assertEquals(expected.getCountOfMatchedNumber(), result.getCountOfMatchedNumber());
		assertEquals(expected.isBonusNumber(), result.isBonusNumber());
		assertEquals(expected.getReward(), result.getReward());

	}


	static Stream<Arguments> createPrizeSuccessDummy() {
		return Stream.of(
			Arguments.arguments(6, false, FIRST_PLACE),
			Arguments.arguments(5, true, SECOND_PLACE),
			Arguments.arguments(5, false, THIRD_PLACE),
			Arguments.arguments(4, false, FOURTH_PLACE),
			Arguments.arguments(3, false, FIFTH_PLACE),
			Arguments.arguments(0, false, LAST_PLACE),
			Arguments.arguments(1, false, LAST_PLACE),
			Arguments.arguments(2, false, LAST_PLACE),
			Arguments.arguments(0, true, LAST_PLACE)
		);
	}
}