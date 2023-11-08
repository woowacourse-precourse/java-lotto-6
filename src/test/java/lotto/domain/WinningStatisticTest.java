package lotto.domain;

import lotto.domain.vo.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticTest {

	@DisplayName("소수점 둘째 자리에서 반올림 하는 수익률을 반환한다.")
	@Test
	void getIncomeRate() {
		//given
		int setMatchNumber = 3;
		boolean setBonus = false;
		LottoResult.setResult(setMatchNumber, setBonus);

		Money inputAmount = new Money(6000);

		double expectedResult = 83.3;
		//when
		WinningStatistic winningStatistic = new WinningStatistic(inputAmount);
		//then
		Assertions.assertThat(winningStatistic.getIncomeRate()).isEqualTo(expectedResult);
	}
}