package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPrizeTest {
	@DisplayName("당첨 번호 6개 일치 - 1등 당첨")
	@Test
	public void checkSixMatch() {
		// given
		int matchCount = 6;
		boolean isBonusNumber = false;

		// when
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, isBonusNumber);

		// then
		Assertions.assertThat(lottoPrizeType).isEqualTo(LottoPrize.FIRST_PRIZE);
	}

	@DisplayName("당첨 번호 5개 일치와 보너스 번호 당첨 - 2등 당첨")
	@Test
	public void checkFiveMatchAndBonus() {
		// given
		int matchCount = 5;
		boolean isBonusNumber = true;

		// when
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, isBonusNumber);

		// then
		Assertions.assertThat(lottoPrizeType).isEqualTo(LottoPrize.SECOND_PRIZE);
	}

	@DisplayName("당첨 번호 5개 일치 - 3등 당첨")
	@Test
	public void checkFiveMatch() {
		// given
		int matchCount = 5;
		boolean isBonusNumber = false;

		// when
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, isBonusNumber);

		// then
		Assertions.assertThat(lottoPrizeType).isEqualTo(LottoPrize.THIRD_PRIZE);
	}

	@DisplayName("당첨 번호 4개 일치 - 4등 당첨")
	@Test
	public void checkFourMatch() {
		// given
		int matchCount = 4;
		boolean isBonusNumber = false;

		// when
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, isBonusNumber);

		// then
		Assertions.assertThat(lottoPrizeType).isEqualTo(LottoPrize.FOURTH_PRIZE);
	}

	@DisplayName("당첨 번호 3개 일치 - 5등 당첨")
	@Test
	public void checkThreeMatch() {
		// given
		int matchCount = 3;
		boolean isBonusNumber = false;

		// when
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, isBonusNumber);

		// then
		Assertions.assertThat(lottoPrizeType).isEqualTo(LottoPrize.FIFTH_PRIZE);
	}

	@DisplayName("당첨 번호 일치가 2개 이하일 때 - 낙첨")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	public void checkThreeMatch(int matchCount) {
		// given
		boolean isBonusNumber = false;

		// when
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, isBonusNumber);

		// then
		Assertions.assertThat(lottoPrizeType).isEqualTo(LottoPrize.BLANK);
	}

}
